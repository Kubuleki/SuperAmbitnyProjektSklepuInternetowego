import org.junit.Assert;
import org.junit.Test;

public class calculatorTest {
    @Test
    public void calculatorAdditionTest_2_3_equals_5(){
        //given
        int a = 2;
        int b = 3;
        double expected = 5;
        Calculator calculator = new Calculator();

        //when
        double result = calculator.sum(a, b);

        //then
        Assert.assertEquals(result, expected, 0.0);
    }
}
