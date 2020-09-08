package com.recommender.api.v1.mapper;

import com.recommender.api.v1.dto.BikeRecommendationRequest;
import com.recommender.api.v1.dto.BikeRecommendationResponse;
import com.recommender.api.v1.dto.BikeResponse;
import com.recommender.domain.model.Bike;
import com.recommender.domain.model.BikeRecommendation;
import com.recommender.domain.model.BikeInput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BikeRecommendationMapper {

    private ModelMapper modelMapper;

    public BikeRecommendationMapper() {
        modelMapper = new ModelMapper();
    }

    public BikeInput toInputEntity(BikeRecommendationRequest input) {
        return modelMapper.map(input, BikeInput.class);
    }

    public BikeResponse toBikeResponse(Bike bike) {
        return modelMapper.map(bike, BikeResponse.class);
    }

    public BikeRecommendationResponse toRecommendationResponse(BikeRecommendation recommendation) {
        return modelMapper.map(recommendation, BikeRecommendationResponse.class);
    }

    public List<BikeResponse> toBikeResponseList(List<Bike> bikes) {
        return bikes.stream().map(bike -> { return toBikeResponse(bike); }).collect(Collectors.toList());
    }

    public List<BikeRecommendationResponse> toRecommendationResponseList(List<BikeRecommendation> recommendations) {
        return recommendations.stream().map(recommendation -> {
            return toRecommendationResponse(recommendation);
        }).collect(Collectors.toList());
    }

}
