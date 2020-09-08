package com.recommender.domain.service;

import com.recommender.domain.builder.BikeBuilder;
import com.recommender.domain.builder.BikeRecommendationBuilder;
import com.recommender.domain.builder.BikeTypeCombinationBuilder;
import com.recommender.domain.model.*;
import com.recommender.domain.repository.BikeRecommendationRepository;
import com.recommender.domain.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeRecommendationService {

    @Autowired
    private BikeRecommendationRepository recommendationRepository;

    @Autowired
    private BikeService bikeService;

    public List<BikeRecommendation> list(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }

    @Transactional
    public BikeRecommendation recommend(BikeInput input, User user) {
        BikeType type = BikeType.getIndicatedTypeByCombinations(buildCombinations(input.getObjectives(), input.getGrounds()));
        BikeQuality quality = BikeQuality.getIndicatedTypeByDistance(input.getMonthDistance());
        BikeSize size = BikeSize.getIndicatedByHeight(input.getCyclistHeight().doubleValue());

        Bike bike = bikeService.createIfNotExists(BikeBuilder.of()
                .withType(type).withQuality(quality).withSize(size).build());

        BikeRecommendation recommendation = BikeRecommendationBuilder.of()
                .withBike(bike).withInput(input).withUser(user).build();

        return recommendationRepository.save(recommendation);
    }

    private List<BikeTypeCombination> buildCombinations(List<String> objectives, List<String> grounds) {
        List<BikeTypeCombination> combinations = new ArrayList<BikeTypeCombination>();
        for (String objective : objectives) {
            for (String ground : grounds) {
                combinations.add(BikeTypeCombinationBuilder.of()
                        .withObjective(ObjectiveType.valueOf(objective))
                        .withGround(GroundType.valueOf(ground)).build());
            }
        }
        return combinations;
    }


}
