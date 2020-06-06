import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static int convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }

    public static String[] getListOfNumbers(String numbers, String regex) {
        return numbers.split(regex);
    }

    public static int[] splitAndGetListOfIntegerNumbers(String numbers, String regex) {
        String[] numberList = splitUsingCustomDelimiterOrByCommaAndNewLine(numbers);
        int[] integerNumbers = new int[numberList.length];
        for (int i = 0; i < numberList.length; i++) {
            integerNumbers[i] = convertStringToInteger(numberList[i]);
        }

        return integerNumbers;
    }

    public static String[] splitUsingCustomDelimiterOrByCommaAndNewLine(String numbers){
        if(numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
            matcher.matches();
            String customDelimiter = matcher.group(1) + "|\n";
            String numbersList = matcher.group(2);
            return getListOfNumbers(numbersList, customDelimiter);
        }else{
            return getListOfNumbers(numbers,",|\n");
        }
    }
}

