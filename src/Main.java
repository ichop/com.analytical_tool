import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        dataAnalyzer.analyze();

//        Pattern pattern = Pattern.compile("[CD]\\s" +
//                "((([1-9]|10)([.][1-3])?)|[*])\\s" +
//                "((([1-9]|10)([.]([1-9]|([1][0-9]|20))([.][1-5])?)?)|[*])\\s" +
//                "[PN]\\s" +
//                "(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})" +
//                "([-](3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2}))?" +
//                "(\\s\\d*)?"
//        );
//        Matcher m = pattern.matcher("D 1 * P ");
//        System.out.println(m.matches());
    }
}
