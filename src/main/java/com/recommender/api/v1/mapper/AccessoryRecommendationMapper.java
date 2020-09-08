package com.recommender.api.v1.mapper;

import com.recommender.api.v1.dto.*;
import com.recommender.domain.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccessoryRecommendationMapper {

    private ModelMapper modelMapper;

    public AccessoryRecommendationMapper() {
        modelMapper = new ModelMapper();
    }

    public AccessoryInput toInputEntity(AccessoryRecommendationRequest input) {
        return modelMapper.map(input, AccessoryInput.class);
    }

    public AccessoryRecommendationResponse toRecommendationResponse(AccessoryRecommendation recommendation) {
        return modelMapper.map(recommendation, AccessoryRecommendationResponse.class);
    }

    public List<AccessoryRecommendationResponse> toRecommendationResponseList(List<AccessoryRecommendation> recommendations) {
        return recommendations.stream().map(recommendation -> {
            return toRecommendationResponse(recommendation);
        }).collect(Collectors.toList());
    }

}
