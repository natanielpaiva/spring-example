package sonar.exemplo.sonarqube.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import sonar.exemplo.sonarqube.BaseTest;
import sonar.exemplo.sonarqube.controller.request.UserRequest;
import sonar.exemplo.sonarqube.controller.request.UserRequestTest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.domain.UserTest;
import sonar.exemplo.sonarqube.mapper.UserRequestToUserMapper;
import sonar.exemplo.sonarqube.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class InsertUserServiceTest extends BaseTest {

    @InjectMocks
    InsertUserService insertUserService;

    @Mock
    UserRepository userRepository;

    @Mock
    UserRequestToUserMapper toUserMapper;

    User user;

    UserRequest userRequest;

    @Before
    public void init(){
        user = UserTest.builderUser();
        userRequest = UserRequestTest.builderUserRequest();
    }

    @Test
    public void insert(){
        when(toUserMapper.apply(userRequest))
                .thenReturn(user);
        when(userRepository.save(user))
                .thenReturn(user);
        var r = insertUserService.apply(userRequest);
        assertEquals(r.getName(), user.getName());
    }
}
