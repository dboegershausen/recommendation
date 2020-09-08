package com.recommender.api.v1.controller;

import com.recommender.api.v1.dto.BikeResponse;
import com.recommender.api.v1.mapper.BikeRecommendationMapper;
import com.recommender.api.v1.dto.BikeRecommendationRequest;
import com.recommender.api.v1.dto.BikeRecommendationResponse;
import com.recommender.domain.model.BikeRecommendation;
import com.recommender.domain.model.BikeInput;
import com.recommender.domain.model.User;
import com.recommender.domain.service.BikeRecommendationService;
import com.recommender.domain.service.BikeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController("BikeRecommendationControllerV1")
@RequestMapping(path = "/api/v1/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Bike Recommendations")
public class BikeRecommendationController {

    @Autowired
    private BikeRecommendationService recommendationService;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private BikeRecommendationMapper recommendationMapper;

    @GetMapping
    public List<BikeRecommendationResponse> list(@AuthenticationPrincipal User loggedUser) {
        return recommendationMapper.toRecommendationResponseList(recommendationService.list(loggedUser.getId()));
    }

    @GetMapping(path = "/top")
    public List<BikeResponse> top() {
        return recommendationMapper.toBikeResponseList(bikeService.topBikes(10));
    }

    @PostMapping
    public ResponseEntity<BikeRecommendationResponse> create(@RequestBody @Valid BikeRecommendationRequest recommendationInput,
                                                             @AuthenticationPrincipal User loggedUser,
                                                             UriComponentsBuilder uriBuilder) {

        BikeInput input = recommendationMapper.toInputEntity(recommendationInput);
        BikeRecommendation recommendation = recommendationService.recommend(input, loggedUser);

        URI path = uriBuilder.path("/api/v1/bikes/{id}")
                .buildAndExpand(recommendation.getId()).toUri();

        return ResponseEntity.created(path).body(recommendationMapper
                .toRecommendationResponse(recommendation));

    }

}
