import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void helloWorldTest(){
    //given
        String given = AppMain.getWelcomeText();
        String expected = "Hello World!";

        Assert.assertEquals(given, expected);
    //when
    //then
    }
}
