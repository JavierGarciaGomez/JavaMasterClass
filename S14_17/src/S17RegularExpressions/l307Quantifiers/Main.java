package S17RegularExpressions.l307Quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
307
    SUMMARY
        -Quantifiers: specify how often an element in a regular expression can occur
        -Pattern class
            -compile()
        -Matcher
            -matches()

    NOTES
        -Generally We use a matcher when we want to find multiple occurrences of a pattern or when we want to use a
            pattern with multiple sequences.




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

        // 307
        System.out.println("\n Lesson 307");
        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*"; //Create it as a String
        Pattern pattern = Pattern.compile(h2Pattern); // Pattern
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
    }
}
