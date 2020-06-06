import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        int[] integerNumbers = StringUtils.splitAndGetListOfIntegerNumbers(numbers);
        StringUtils.ensureAllNonNegatives(integerNumbers);
        return Calculator.sum(integerNumbers);

    }

}
