package com.recommender.api.v1.controller;

import com.recommender.api.v1.dto.AccessoryRecommendationRequest;
import com.recommender.api.v1.dto.AccessoryRecommendationResponse;
import com.recommender.api.v1.mapper.AccessoryRecommendationMapper;
import com.recommender.domain.model.AccessoryInput;
import com.recommender.domain.model.AccessoryRecommendation;
import com.recommender.domain.model.User;
import com.recommender.domain.service.AccessoryRecommendationService;
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

@RestController("AccessoryRecommendationControllerV1")
@RequestMapping(path = "/api/v1/accessories", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Accessory Recommendations")
public class AccessoryRecommendationController {

    @Autowired
    private AccessoryRecommendationService recommendationService;

    @Autowired
    private AccessoryRecommendationMapper recommendationMapper;

    @GetMapping
    public List<AccessoryRecommendationResponse> list(@AuthenticationPrincipal User loggedUser) {
        return recommendationMapper.toRecommendationResponseList(recommendationService.list(loggedUser.getId()));
    }

    @PostMapping
    public ResponseEntity<AccessoryRecommendationResponse> create(@RequestBody @Valid AccessoryRecommendationRequest recommendationInput,
          @AuthenticationPrincipal User loggedUser, UriComponentsBuilder uriBuilder) {

        AccessoryInput input = recommendationMapper.toInputEntity(recommendationInput);
        AccessoryRecommendation recommendation = recommendationService.recommend(input, loggedUser);

        URI path = uriBuilder.path("/api/v1/accessories/{id}")
                .buildAndExpand(recommendation.getId()).toUri();

        return ResponseEntity.created(path).body(recommendationMapper
                .toRecommendationResponse(recommendation));

    }

}
