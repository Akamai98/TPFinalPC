
/**
 * @author Luna, Lihué Leandro
 * @author Coronati, Federico Joaquín
 * @author Merino, Mateo
 * @author Bonino, Francisco Ignacio
 * @since 07/07/2020
 */

import java.util.ArrayList;

import Jama.Matrix;

public class MyThread extends Thread {

    // Campos privados
    private Matrix firingVector; // Este vector indica la transicion que se disparará o que se intentó disparar. FJC
    // private Matrix myTransitions; // Este vector tiene las transiciones que puede disparar el hilo. FJC
    private ArrayList<Matrix> myTransitions;
    private Monitor monitor;
    private boolean working;

    /**
     * Constructor.
     * 
     * @param firingVector Vector de transiciones asociadas al hilo.
     * @param monitor Referencia al monitor que controla la red de Petri.
     */
    public MyThread(Matrix sequence, Monitor monitor) {
        myTransitions = new ArrayList<Matrix>();

        this.monitor = monitor;
        this.working = false;

        for (int i = 0; i < sequence.getColumnDimension(); i++)
            myTransitions.add(getTransitionVector((int) sequence.get(0, i)));
    }

    // ----------------------------------------Métodos públicos---------------------------------

    // ----------------------------------------Getters------------------------------------------

    /**
     * @return El vector de transiciones a disparar.
     */
    public Matrix getFiringVector() {
        return firingVector;
    }

    /**
     * @return El vector de transiciones asociadas al hilo.
     */
    public ArrayList<Matrix> getAssociatedTransitions() {
        return myTransitions;
    }

    // ----------------------------------------Overrides----------------------------------------

    @Override
    public void run() {
        int i = 0;

        while (!monitor.getPetriNet().hasCompleted()) { // El run termina luego de N transiciones exitosas entre todos los hilos en conjunto
            firingVector = myTransitions.get(i);

            try {
                // System.out.println(Thread.currentThread().getId() + ": Intento catchear el
                // monitor");
                monitor.catchMonitor();
                if (monitor.getPetriNet().hasCompleted())
                    break; // Mientras estabamos peleando por el mutex, se terminaron las tareas?
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId() + ": Guacho hay bardo para entrar al monitor");
            }

            // System.out.println(Thread.currentThread().getId() + ": Voy a disparar. fV:");

            // firingVector.print(0,0);

            if (!monitor.getPetriNet().stateEquationTest(firingVector)) {
                // System.out.println(Thread.currentThread().getId() + ": No pude disparar porque la transición no está sensibilizada.");
                monitor.exitMonitor();

                try {
                    // System.out.println(Thread.currentThread().getId() + ": Me voy a encolar en la cola de condicion de la transicion: T" + monitor.getIndexHigh(firingVector));

                    monitor.getConditionQueues().get(monitor.getIndexHigh(firingVector)).acquire(); // Cuando se despierta se continua a partir de aca

                    if (monitor.getPetriNet().hasCompleted())
                        break;

                    // System.out.println(Thread.currentThread().getId() + ": Me desperté, voy a triggerear la transicion: " + monitor.getIndexHigh(firingVector));
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getId() + "Error al encolar un hilo.");
                }
            } else {
                if (!working) {
                    if (monitor.getPetriNet().getWorkingVector().get(0, monitor.getIndexHigh(firingVector)) == 1) {
                        // System.out.println(Thread.currentThread().getId() + ": Ya hay alguien trabajando en la transicion");
                        monitor.exitMonitor();

                        try {
                            // System.out.println(Thread.currentThread().getId() + ": Me voy a encolar en la cola de condicion de la transicion: T" + monitor.getIndexHigh(firingVector));

                            monitor.getConditionQueues().get(monitor.getIndexHigh(firingVector)).acquire(); // Cuando se despierta se continua a partir de aca

                            if (monitor.getPetriNet().hasCompleted())
                                break;

                            // System.out.println(Thread.currentThread().getId() + ": Me desperté, voy a triggerear la transicion: " + monitor.getIndexHigh(firingVector));
                        } catch (Exception e) {
                            System.out.println(Thread.currentThread().getId() + "Error al encolar un hilo.");
                        }
                    }
                }
            }

            // Si aún no pasó alfa y no hay nadie trabajando en esa misma transición...
            if (!monitor.alphaTimeCheck(firingVector)) {
                monitor.exitMonitor();

                try {
                    // System.out.println(Thread.currentThread().getId() + ": No pasó alfa. Voy a
                    // trabajar durante: " + monitor.getWaitingTime() + " ms");
                    monitor.getPetriNet().getWorkingVector().set(0, monitor.getIndexHigh(firingVector), 1);
                    working = true;
                    sleep(monitor.getWorkingTime());
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getId() + ": Error en tiempo de sleep");
                }

                // System.out.println(Thread.currentThread().getId() + ": Terminé de trabajar (alfa), voy a pelear por el mutex.");

                // monitor.getPetriNet().getWorkingVector().set(0, monitor.getIndexHigh(firingVector), 0);

                continue;
            }

            monitor.getPetriNet().fireTransition(firingVector);

            working = false;
                    
            Matrix EandW = monitor.getAnd();

            //System.out.println(Thread.currentThread().getId() + ": Llamando a waitingCheck sin haber waiteado antes.");
                
            monitor.waitingCheck(EandW);
            
            i++;
            
            if(i>=myTransitions.size()) i=0; //la dimension de myTransitions deberia ser 19
        }

        System.out.println(Thread.currentThread().getId() + ": Terminó mi run()");

        //System.out.println(monitor.getPetriNet().getMemoriesLoad());
       // System.out.println(monitor.getPetriNet().getProcessorsLoad());
       // System.out.println(monitor.getPetriNet().getProcessorsTasks());
    }

    // ----------------------------------------Otros------------------------------------------

    /**
     * @param i Índice de la transición que se quiere obtener.
     * @return Vector con ceros y un '1' en la i-ésima transición.
     */
    public Matrix getTransitionVector(int i) {
        Matrix vector = new Matrix(1,monitor.getPetriNet().getIncidenceMatrix().getColumnDimension());
        
        vector.set(0,i,1);
        
        return vector;
    }
}