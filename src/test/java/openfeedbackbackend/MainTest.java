package openfeedbackbackend;

import org.testng.*;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void getHelloMessage() {
        Assert.assertEquals("<h1>Hello World!</h1>", Main.getHelloMessage());
    }

}
