import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.Add("1"));
    }
}
