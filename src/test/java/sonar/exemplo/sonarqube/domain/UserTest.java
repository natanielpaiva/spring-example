package sonar.exemplo.sonarqube.domain;

import java.time.LocalDate;
import org.junit.Test;
import sonar.exemplo.sonarqube.BaseTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest extends BaseTest {

    public static User builderUser() {
        return User.builder()
                .birthDate(LocalDate.now())
                .id(1L)
                .name("Nataniel Paiva")
                .phoneNumber("61991303407")
                .build();
    }

    @Test
    public void testObject() {
        var r = builderUser();
        assertAll(r);
    }

    @Test
    public void testSetter() {
        var user = new User();
        user.setBirthDate(LocalDate.now());
        user.setId(1L);
        user.setName("Nataniel Paiva");
        user.setPhoneNumber("61991303407");
        assertAll(user);
    }

    private void assertAll(User r) {
        assertNotNull(r.getBirthDate());
        assertNotNull(r.getId());
        assertNotNull(r.getName());
        assertNotNull(r.getPhoneNumber());
    }

}
