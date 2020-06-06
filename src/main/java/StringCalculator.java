import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        } else {
            int[] integerNumbers = StringUtils.splitAndGetListOfIntegerNumbers(numbers, ",|\n");
            int[] negativeNumbers = Arrays.stream(integerNumbers).filter(x -> x < 0).toArray();
            if(negativeNumbers.length > 0){
                throw new RuntimeException("Negatives not allowed: -1");
            }
            return Calculator.sum(integerNumbers);
        }
    }

}
