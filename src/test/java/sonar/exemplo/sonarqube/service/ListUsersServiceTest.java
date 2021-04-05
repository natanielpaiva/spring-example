package sonar.exemplo.sonarqube.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sonar.exemplo.sonarqube.BaseTest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.repository.UserRepository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ListUsersServiceTest extends BaseTest {

    @InjectMocks
    ListUsersService listUsersService;

    @Mock
    UserRepository userRepository;

    Page<User> users;

    @Before
    public void init(){
        users = Page.empty();
    }

    @Test
    public void paginationDefault(){
        Integer page = null;
        Integer size = null;
        when(userRepository.findAll(any(Pageable.class))).thenReturn(users);
        var r = listUsersService.apply(page, size);
        assertNotNull(r);
    }

    @Test
    public void paginationWithParams(){
        Integer page = 0;
        Integer size = 10;
        when(userRepository.findAll(any(Pageable.class))).thenReturn(users);
        var r = listUsersService.apply(page, size);
        assertNotNull(r);
    }

}
