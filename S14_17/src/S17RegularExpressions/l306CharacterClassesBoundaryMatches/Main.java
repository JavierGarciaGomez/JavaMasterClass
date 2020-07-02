package S17RegularExpressions.l306CharacterClassesBoundaryMatches;
/*
305
    SUMMARY
        -ReplacewithExceptions

    NOTES


    CODE


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

        // 306
        System.out.println("\n Lesson 306");
        System.out.println("harry".replaceAll("[Hh]arry", "Larry")); // Replace
        System.out.println(alphanumeric.replaceAll("[^eji]","X")); // Replace with exceptions
        System.out.println(alphanumeric.replaceAll("[^eji]","X")); // Replace with exceptions
        System.out.println(alphanumeric.replaceAll("[a-fD-F3-8]","R")); // Replace ranges
        System.out.println(alphanumeric.replaceAll("(?i)[j-l3-8]","R")); // Replace ignoring casesensitivy
        System.out.println(alphanumeric.replaceAll("\\d", "X")); // Replace digits
        System.out.println(alphanumeric.replaceAll("\\D", "X")); // Replace nondigits
        // \\s to remove spaces
        // \\t to remove tabs
        // \\S to replace white space chacarters
        // \\w to replace non white space
        // \\b to replace begin and end of word







    }
}
