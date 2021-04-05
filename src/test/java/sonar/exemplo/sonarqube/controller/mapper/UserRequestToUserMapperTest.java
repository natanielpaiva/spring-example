package sonar.exemplo.sonarqube.controller.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import sonar.exemplo.sonarqube.BaseTest;
import sonar.exemplo.sonarqube.controller.request.UserRequestTest;
import sonar.exemplo.sonarqube.domain.UserTest;
import sonar.exemplo.sonarqube.mapper.UserRequestToUserMapper;

public class UserRequestToUserMapperTest extends BaseTest {

    @InjectMocks
    UserRequestToUserMapper toUserMapper;

    @Test
    public void testToUser(){
        var user = UserTest.builderUser();
        var userRequest = UserRequestTest.builderUserRequest();
        var r = toUserMapper.apply(userRequest);
        Assert.assertEquals(r.getName(), user.getName());
        Assert.assertEquals(r.getBirthDate(), user.getBirthDate());
        Assert.assertEquals(r.getPhoneNumber(), user.getPhoneNumber());

    }

}
