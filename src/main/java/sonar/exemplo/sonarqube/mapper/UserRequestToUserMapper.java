package sonar.exemplo.sonarqube.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sonar.exemplo.sonarqube.controller.request.UserRequest;
import sonar.exemplo.sonarqube.domain.User;

@Component
public class UserRequestToUserMapper {

    public User apply(UserRequest userRequest){
        var user = User.builder().build();
        BeanUtils.copyProperties(userRequest, user);
        return user;
    }

}
