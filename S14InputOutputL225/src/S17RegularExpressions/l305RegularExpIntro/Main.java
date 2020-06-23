package S17RegularExpressions.l305RegularExpIntro;
/*
305
    SUMMARY
        -replaceAll()
        -Character classes
        -Character boundary ^ ocurrence at the beggining
        -Check Regex feature in IntelliJ (clicking and in the warning can be open)
        -matches()

    NOTES
        The simplest form of a regular expression is a String literal f.e. "Hello"
        "." matches all characters


    CODE
        2: replaceAll()


*/
public class Main {
    public static void main(String[] args) {
        String string = "I am a String. Yes I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric ="abcDeeeF12Ghhiiiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee","YYY")); // replaces the beggining letters if the regex begin with that

        alphanumeric ="abcDeeeF12GhabcDhiiiiiijkl99z";
        System.out.println(alphanumeric.replaceAll("^abcD","YY")); // the same, as an example it doest replace every ocurrence

        System.out.println("Doest it match eee "+alphanumeric.matches("^eee"));
        System.out.println("Doest it match abcD "+alphanumeric.matches("^YY"));

        System.out.println(alphanumeric.replaceAll("[aei]","REPLACED")); // replaces all the characters
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","REPLACED")); // replace letters that are followed by other letters

    }
}
