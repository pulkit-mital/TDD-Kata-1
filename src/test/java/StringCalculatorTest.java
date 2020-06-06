import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.Add("1"));
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.Add("1,2"));
    }

    @Test
    public void shouldReturnSumOfMultipleNumbersByCommaDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.Add("1,2,3"));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimiter(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, stringCalculator.Add("1\n2,3"));
    }
}
