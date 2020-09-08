package com.recommender;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recommender.api.v1.dto.BikeRecommendationRequest;
import com.recommender.core.security.jwt.TokenManager;
import com.recommender.domain.model.GroundType;
import com.recommender.domain.model.ObjectiveType;
import com.recommender.domain.model.User;
import com.recommender.domain.service.BikeRecommendationService;
import com.recommender.domain.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.util.UriTemplate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class BikeRecommendationControllerTest {

    private static final String ENDPOINT = "/api/v1/bikes";

    private String jwt;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private BikeRecommendationService recommendationService;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authManager;

    @Before
    public void setup() throws RuntimeException {
        String rawPassword = "123";
        User user = new User();
        user.setEmail("john.doe@gmail.com");
        user.setPassword(rawPassword);
        userService.create(user);

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), rawPassword));
        jwt = this.tokenManager.generateToken(authentication);
    }

    @Test
    public void shouldRecommendBikes() throws Exception {
        URI uri = new UriTemplate(ENDPOINT).expand();

        BikeRecommendationRequest recommendationRequest = new BikeRecommendationRequest();
        recommendationRequest.setObjectives(Arrays.asList(ObjectiveType.CITY.name()));
        recommendationRequest.setGrounds(Arrays.asList(GroundType.NORMAL_ROAD.name()));
        recommendationRequest.setCyclistHeight(BigDecimal.valueOf(1.70));
        recommendationRequest.setMonthDistance(200);

        MockHttpServletRequestBuilder request = post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + jwt)
                .content(new ObjectMapper().writeValueAsString(recommendationRequest));

        this.mockMvc.perform(request)
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldListTopBikes() throws Exception {
        URI uri = new UriTemplate(ENDPOINT.concat("/top")).expand();

        MockHttpServletRequestBuilder request = get(uri);

        this.mockMvc.perform(request)
                .andExpect(status().isOk());
    }

}
