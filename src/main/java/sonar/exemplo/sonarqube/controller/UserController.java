package sonar.exemplo.sonarqube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sonar.exemplo.sonarqube.controller.request.UserRequest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.service.FindByIdUserService;
import sonar.exemplo.sonarqube.service.InsertUserService;
import sonar.exemplo.sonarqube.service.ListUsersService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    InsertUserService insertUserService;

    @Autowired
    ListUsersService listUsersService;

    @Autowired
    FindByIdUserService findByIdUserService;

    @PostMapping
    public User save(@RequestBody @Validated UserRequest userRequest) {
        return insertUserService.apply(userRequest);
    }

    @GetMapping
    public Page<User> listAll(@RequestParam(name = "page", required = false) Integer page,
                              @RequestParam(value = "size", required = false) Integer size){
        return listUsersService.apply(page, size);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return findByIdUserService.apply(id);
    }

}
