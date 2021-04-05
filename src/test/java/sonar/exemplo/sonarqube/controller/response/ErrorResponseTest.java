package sonar.exemplo.sonarqube.controller.response;

import org.junit.Test;
import sonar.exemplo.sonarqube.BaseTest;

import static org.junit.Assert.assertNotNull;

public class ErrorResponseTest extends BaseTest {

    public static ErrorResponse builderErrorResponse(){
        return ErrorResponse.builder()
                .message("aaa")
                .status(200)
                .build();
    }

    @Test
    public void testObject(){
        var r = builderErrorResponse();
        assertAll(r);
    }

    @Test
    public void testSetter(){
        var r = new ErrorResponse();
        r.setMessage("aaA");
        r.setStatus(200);
        assertAll(r);
    }

    private void assertAll(ErrorResponse r){
        assertNotNull(r.getMessage());
        assertNotNull(r.getStatus());
    }
}
