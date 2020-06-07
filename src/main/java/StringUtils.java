import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtils {

    public static int convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }

    public static String[] getListOfNumbers(String numbers, String regex) {
        return numbers.split(regex);
    }

    public static int[] splitAndGetListOfIntegerNumbers(String numbers) {
        String[] numberList = splitUsingCustomDelimiterOrByCommaAndNewLine(numbers);
        int[] integerNumbers = new int[numberList.length];
        for (int i = 0; i < numberList.length; i++) {
            integerNumbers[i] = convertStringToInteger(numberList[i]);
        }
        return Arrays.stream(integerNumbers).filter(x -> x < 1000).toArray();
    }

    public static String[] splitUsingCustomDelimiterOrByCommaAndNewLine(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new String[0];
        } else if (numbers.startsWith("//[")) {
            String[] delimiters = numbers.substring(numbers.indexOf("[") + 1, numbers.lastIndexOf("]")).split("]\\[");
            String restOfNumbers = numbers.substring(numbers.indexOf("\n") + 1, numbers.length());
            return getListOfNumbers(restOfNumbers, (createRegexFromDelimiters(delimiters)));
        } else if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
            matcher.matches();
            String customDelimiter = matcher.group(1);
            String numbersList = matcher.group(2);
            return getListOfNumbers(numbersList, Pattern.quote(customDelimiter) + "|\n");
        } else {
            return getListOfNumbers(numbers, ",|\n");
        }
    }

    public static void ensureAllNonNegatives(int[] numbers) {
        int[] negativeNumbers = Arrays.stream(numbers).filter(x -> x < 0).toArray();
        if (negativeNumbers.length > 0) {
            throw new RuntimeException("Negatives not allowed: -1");
        }
    }

    private static String createRegexFromDelimiters(String[] delimiters) {
        return Arrays.stream(delimiters).map(Pattern::quote).collect(Collectors.joining("|"));
    }


}

