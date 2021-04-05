package sonar.exemplo.sonarqube.controller;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import sonar.exemplo.sonarqube.BaseTest;
import sonar.exemplo.sonarqube.controller.response.ErrorResponse;
import sonar.exemplo.sonarqube.exceptions.ResourceNotFoundException;

import static org.junit.Assert.assertEquals;

public class InterceptControllerTest extends BaseTest {

    @InjectMocks
    InterceptController interceptController;

    ResponseEntity<ErrorResponse> errorResponseResponseEntity;

    Exception e;

    ResourceNotFoundException foundException;

    @Mock
    MethodArgumentNotValidException methodArgumentNotValidException;

    @Test
    public void errorResponseResponseEntity() {
        e = new Exception("aa");
        var result = interceptController.errorResponseResponseEntity(e);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    public void errorInvalid() {
        foundException = new ResourceNotFoundException("aa");
        var result = interceptController.errorInvalid(foundException);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void error() {
        var result = interceptController.errorInvalid(methodArgumentNotValidException);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, result.getStatusCode());
    }

}
