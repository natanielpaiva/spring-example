package sonar.exemplo.sonarqube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.exceptions.ResourceNotFoundException;
import sonar.exemplo.sonarqube.repository.UserRepository;

@Service
public class FindByIdUserService {

    @Autowired
    UserRepository userRepository;

    public User apply(Long id){
        var userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuario nao encontrado");
        }
        return userOptional.get();
    }
}
