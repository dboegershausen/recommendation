package com.recommender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recommender.api.v1.dto.UserRequest;
import com.recommender.core.security.jwt.TokenManager;
import com.recommender.domain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.util.UriTemplate;

import javax.transaction.Transactional;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String ENDPOINT = "/api/v1/users";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateNewUser() throws Exception {
        URI uri = new UriTemplate(ENDPOINT).expand();

        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("john.doe@gmail.com");
        userRequest.setPassword("123");

        MockHttpServletRequestBuilder request = post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userRequest));

        this.mockMvc.perform(request)
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldRejectNewUserWithSameEmail() throws Exception {
        URI uri = new UriTemplate(ENDPOINT).expand();

        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("john.doe@gmail.com");
        userRequest.setPassword("123");

        MockHttpServletRequestBuilder request = post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userRequest));

        this.mockMvc.perform(request);
        this.mockMvc.perform(request)
                .andExpect(status().isBadRequest());

    }
}
