public class StringUtils {

    public static int convertStringToInteger(String number) {
        return Integer.parseInt(number);
    }

    public static String[] getListOfNumbers(String numbers, String regex) {
        return numbers.split(regex);
    }

    public static int[] splitAndGetListOfIntegerNumbers(String numbers, String regex) {
        String[] numberList = getListOfNumbers(numbers, regex);
        int[] integerNumbers = new int[numberList.length];
        for (int i = 0; i < numberList.length; i++) {
            integerNumbers[i] = convertStringToInteger(numberList[i]);
        }

        return integerNumbers;
    }
}

