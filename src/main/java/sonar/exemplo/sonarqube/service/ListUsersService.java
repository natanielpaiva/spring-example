package sonar.exemplo.sonarqube.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.repository.UserRepository;

@Service
public class ListUsersService {

    @Autowired
    UserRepository userRepository;

    public Page<User> apply(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        if (!Objects.isNull(page) && !Objects.isNull(size)) {
            pageRequest = PageRequest.of(page, size);
        }
        return userRepository.findAll(pageRequest);

    }
}
