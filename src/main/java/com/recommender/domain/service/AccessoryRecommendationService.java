package com.recommender.domain.service;

import com.recommender.domain.builder.AccessoryRecommendationBuilder;
import com.recommender.domain.model.*;
import com.recommender.domain.repository.AccessoryRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccessoryRecommendationService {

    @Autowired
    private AccessoryRecommendationRepository recommendationRepository;

    public List<AccessoryRecommendation> list(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }

    @Transactional
    public AccessoryRecommendation recommend(AccessoryInput input, User user) {

        AccessoryRecommendation recommendation = AccessoryRecommendationBuilder.of().withAccessories(AccessoryType
                .getIndicatedTypesByDistance(input.getDistance())).withInput(input).withUser(user).build();

        return recommendationRepository.save(recommendation);
    }

}
