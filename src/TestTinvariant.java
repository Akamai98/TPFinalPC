import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestTinvariant {
    
    final static ArrayList<String> netInvariants = new ArrayList<String>();

    final static String regex1 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T5,)((?!(T5,)).)*(T9,)((?!(T9,)).)*(T15,)";
    
    final static String regex2 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T5,)((?!(T5,)).)*(T10,)((?!(T10,)).)*(T16,)";

    final static String regex3 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T6,)((?!(T6,)).)*(T11,)((?!(T11,)).)*(T15,)";

    final static String regex4 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T6,)((?!(T6,)).)*(T12,)((?!(T12,)).)*(T16,)";

    final static String regex5 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T13,)((?!(T13,)).)*(T7,)((?!(T7,)).)*(T9,)((?!(T9,)).)*(T15,)";

    final static String regex6 = "(T0,)((?!(T0,)).)*(T1,)((?!(T1,)).)*(T3,)((?!(T3,)).)*(T13,)((?!(T13,)).)*(T7,)((?!(T7,)).)*(T10,)((?!(T10,)).)*(T16,)";
    
    final static String regex7 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T14,)((?!(T14,)).)*(T8,)((?!(T8,)).)*(T11,)((?!(T11,)).)*(T15,)";

    final static String regex8 = "(T0,)((?!(T0,)).)*(T2,)((?!(T2,)).)*(T4,)((?!(T4,)).)*(T14,)((?!(T14,)).)*(T8,)((?!(T8,)).)*(T12,)((?!(T12,)).)*(T16,)";

    public static void main(String args[]) {
        netInvariants.add(regex1);
        netInvariants.add(regex2);
        netInvariants.add(regex3);
        netInvariants.add(regex4);
        netInvariants.add(regex5);
        netInvariants.add(regex6);
        netInvariants.add(regex7);
        netInvariants.add(regex8);

        /*String outputSequence = "[T0, T1, T3, T0, T1, T0, T1, T0, T1, T0, T2, T0, T2, T0, T2, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T10, T3, T16, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5,"+
         "T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T9, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4,"+
         "T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T4, T16, T0, T2, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T12, T4, T16, T0, T2, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T5, T10, T4, T16, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T4, T15, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T4, T15, T0, T2, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T11, T4, T15, T0, T2, T6, T3, T11, T15, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T3, T12, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T4, T10, T16, T0, T1, T6, T11, T3, T15, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T5, T10, T4, T16, T0, T1, T6, T3, T12, T16, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T11, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T9, T15, T0, T1, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T13, T7, T10, T4, T16, T0, T1, T14, T8, T3, T11, T15, T0, T2, T5, T10, T4, T16, T0, T1, T14, T8, T3, T12, T16, T0, T2, T13, T7, T4, T9, T15, T0, T1, T6, T11, T3, T15, T0, T2, T5, T4, T9, T15, T0, T1, T6, T3, T12, T16, T0, T2, T5, T10, T3, T16, T0, T1, T13, T7, T9, T3, T15, T0, T1, T13, T7, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T4, T16, T0, T2, T14, T8, T11, T3, T15, T0, T2, T13, T7, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T10, T3, T16, T0, T1, T5, T9, T3, T15, T0, T1, T5, T4, T10, T16, T0, T1, T6, T11, T4, T15, T0, T2, T6, T12, T3, T16, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, ]";
        */

        String outputSequence = "[T0, T1, T3, T0, T1, T0, T1, T0, T1, T0, T2, T0, T2, T0, T2, T0, T2, T5, T9, T4, T15, T0, T1, T14, T8, T12, T4, T16, T0, T2, T6, T3, T12, T16, T0, T2, T13, T7, T9, T4, T15, T0, T1, T6, T3, T11, T15, T0, T2, T5, T4, T10, T16, T0, T1, T14, T8, T12, T3, T16, T0, T2, T13, T7, T4, T10, T16, T0, T1, T6, T12, T3, T16, T0, T2, T5, T10, T3, T16, T0, T1, T5, T9, T3, T15, ]";
        System.out.println(outputSequence.length());
        
        Pattern pattern = Pattern.compile(netInvariants.get(0), Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(outputSequence);

        int cantidad = 0;

        String pre, post, middle;

        while(matcher.find()) {
            for(int i=1; i<matcher.groupCount(); i++) {
                middle = "";

                if((i-1)%3==0) { //Si el grupo corresponde a un (multiplo de 3) + 1
                    pre = outputSequence.substring(0, matcher.start(i));
                    post = outputSequence.substring(matcher.end(i));

                    for(int j=0; j<(matcher.end(i)-matcher.start(i)); j++)
                        middle += "_";

                    outputSequence = pre + middle + post;

                   // System.out.println("pre: " + pre + "\nmiddle: " + middle + "\npost: " + post + "\noutputSequence: " + outputSequence);

                    System.out.println("outputSequence: " + outputSequence);
                  //outputSequence = outputSequence.substring(0, matcher.start(i)-1).concat(outputSequence.substring(matcher.end(i)+1, outputSequence.length())); //Tomamos [start(i) - 1] y [end(i) + 1] para retirar los matches 
                    
                    //System.out.println("Group " + i + ": " + matcher.group(i) + "  " + matcher.start(i) + "-" + matcher.end(i));
                }
            }
            
            cantidad++;
            System.out.println("ENCONTRÉ " + cantidad + " VECES.");
        }
        
        System.out.println(outputSequence.length());
    }
}