package openfeedbackbackend.integrationtest;

import org.testng.*;
import org.testng.annotations.*;

import io.restassured.*;
import openfeedbackbackend.*;

public class ServerTest {

    @Test
    public void receiveHelloMessageOnPort8080() throws Exception {
        final Thread t = new Thread() {
            @Override
            public void run(){
                try {
                    Main.main(null);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        final String response =
            RestAssured
            .get("localhost:8080")
            .then()
            .assertThat()
            .statusCode(200)
            .extract()
            .asString();
        Assert.assertTrue(response.startsWith("<h1>Hello World!</h1>"));
    }

}
