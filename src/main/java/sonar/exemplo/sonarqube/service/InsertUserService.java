package sonar.exemplo.sonarqube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonar.exemplo.sonarqube.controller.request.UserRequest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.mapper.UserRequestToUserMapper;
import sonar.exemplo.sonarqube.repository.UserRepository;

@Service
public class InsertUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRequestToUserMapper toUserMapper;

    public User apply(UserRequest userRequest){
        var user = toUserMapper.apply(userRequest);
        return userRepository.save(user);
    }

}
