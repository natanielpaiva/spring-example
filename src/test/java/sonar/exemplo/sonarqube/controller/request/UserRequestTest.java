package sonar.exemplo.sonarqube.controller.request;

import java.time.LocalDate;
import org.junit.Test;
import sonar.exemplo.sonarqube.BaseTest;

import static org.junit.Assert.assertNotNull;

public class UserRequestTest extends BaseTest {

    public static UserRequest builderUserRequest() {
        return UserRequest.builder()
                .name("Nataniel Paiva")
                .birthDate(LocalDate.now())
                .phoneNumber("61991303407")
                .build();
    }

    @Test
    public void testObject() {
        var r = builderUserRequest();
        assertAll(r);
    }

    @Test
    public void testSetters() {
        var r = new UserRequest();
        r.setBirthDate(LocalDate.now());
        r.setName("Nataniel Paiva");
        r.setPhoneNumber("61991303407");
        assertAll(r);
    }

    private void assertAll(UserRequest r) {
        assertNotNull(r.getBirthDate());
        assertNotNull(r.getName());
        assertNotNull(r.getPhoneNumber());
    }

}
