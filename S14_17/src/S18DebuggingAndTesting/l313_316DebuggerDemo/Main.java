package S18DebuggingAndTesting.l313DebuggerDemo;

public class Main {
    public static void main(String[] args) {
        StringUtilities utilities = new StringUtilities();
        StringBuilder stringBuilder = new StringBuilder();
        while(stringBuilder.length()<10){
            utilities.addChar(stringBuilder, 'a'); // adding a char for 10 times
        }
        System.out.println(stringBuilder);

        String str = "abcde";
        String result = utilities.upperAndPrefix(utilities.addSuffix(str));

        System.out.println(result);
    }

}
