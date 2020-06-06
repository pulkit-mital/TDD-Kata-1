public class StringCalculator {
    public int Add(String numbers) {
        if(numbers == null || numbers.isEmpty()) {
            return 0;
        }else{
            return StringUtils.convertStringToInteger(numbers);
        }
    }
}
