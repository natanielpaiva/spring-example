package sonar.exemplo.sonarqube.service;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import sonar.exemplo.sonarqube.BaseTest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.domain.UserTest;
import sonar.exemplo.sonarqube.exceptions.ResourceNotFoundException;
import sonar.exemplo.sonarqube.repository.UserRepository;

public class FindByIdUserServiceTest extends BaseTest {

    @InjectMocks
    FindByIdUserService findByIdUserService;

    @Mock
    UserRepository userRepository;

    User user;

    @Before
    public void init(){
        user = UserTest.builderUser();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testEmpty(){
        Optional<User> userOptional = Optional.empty();
        Mockito.when(userRepository.findById(user.getId()))
                .thenReturn(userOptional);
        findByIdUserService.apply(user.getId());
    }

    @Test
    public void testNotEmpty(){
        Optional<User> userOptional = Optional.of(user);
        Mockito.when(userRepository.findById(user.getId()))
                .thenReturn(userOptional);
        var r = findByIdUserService.apply(user.getId());
        Assert.assertEquals(r.getId(), user.getId());
    }

}
