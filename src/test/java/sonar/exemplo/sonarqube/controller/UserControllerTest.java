package sonar.exemplo.sonarqube.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sonar.exemplo.sonarqube.controller.request.UserRequestTest;
import sonar.exemplo.sonarqube.domain.User;
import sonar.exemplo.sonarqube.domain.UserTest;
import sonar.exemplo.sonarqube.service.FindByIdUserService;
import sonar.exemplo.sonarqube.service.InsertUserService;
import sonar.exemplo.sonarqube.service.ListUsersService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InsertUserService insertUserService;

    @MockBean
    ListUsersService listUsersService;

    @MockBean
    FindByIdUserService findByIdUserService;

    @Test
    public void testFindById() throws Exception {

        Mockito.when(findByIdUserService.apply(1L))
                .thenReturn(User.builder().id(1L).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());
    }

    @Test
    public void testFindList() throws Exception {
        var page = 0;
        var size = 1;
        Page<User> users = new PageImpl<>(Collections.singletonList(UserTest.builderUser()));
        Mockito.when(listUsersService.apply(page, size))
                .thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/user?page=" + page + "&size="+size))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray());
    }

    @Test
    public void testSave() throws Exception {
        var userRequest = UserRequestTest.builderUserRequest();
        Mockito.when(insertUserService.apply(Mockito.any()))
                .thenReturn(UserTest.builderUser());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        userRequest.setBirthDate(null);
        String requestJson=ow.writeValueAsString(userRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber());
    }
}
