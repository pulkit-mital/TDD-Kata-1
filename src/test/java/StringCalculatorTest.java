import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void shouldAcceptCustomDelimiterSyntax(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

    @Test
    public void customDelimiterCouldBeAlsoARegExpSpecialChar(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.Add("//.\n1.2"));
    }

    @Test
    public void shouldRaiseExceptionOnNegative(){
        try{
            StringCalculator stringCalculator = new StringCalculator();
            stringCalculator.Add("-1,2,3");
            fail("Exception Expected");
        }catch (RuntimeException ex){
            //throws runtime exception
        }
    }

    @Test
    public void exceptionMessageShouldContainNegatives(){
        try{
            StringCalculator stringCalculator = new StringCalculator();
            stringCalculator.Add("-1,2,3");
            fail("Exception Expected");
        }catch (RuntimeException ex){
            assertEquals("Negatives not allowed: -1", ex.getMessage());
        }
    }

    @Test
    public void addNumbersIgonreNumbergreaterThan1000(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.Add("2,1001"));
    }
}
