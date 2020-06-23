package S17RegularExpressions.l308MatcherFindGroupMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
308
    SUMMARY

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

        String h2Pattern = "<h2>"; //Create it as a String
        Pattern pattern = Pattern.compile(h2Pattern); // Pattern
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        System.out.println("\n Lesson 308");
        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());

        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPatten = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPatten.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        System.out.println("\n Lesson 309");
        // "abc" "a" and "b" and "c"
        // [[Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc]
        String tvTest = "tstvtkt";
//      String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
        // t(?=v)
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }
}