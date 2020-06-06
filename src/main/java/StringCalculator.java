public class StringCalculator {
    public int Add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        } else {
            return Calculator.sum(StringUtils.splitAndGetListOfIntegerNumbers(numbers, ",|\n"));
        }
    }

    public static void main(String[] args){
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.Add("//;\n1;2"));

    }
}
