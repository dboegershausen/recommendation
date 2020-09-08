package com.recommender.domain.repository;

import com.recommender.domain.model.AccessoryRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessoryRecommendationRepository extends JpaRepository<AccessoryRecommendation, Long> {

    List<AccessoryRecommendation> findByUserId(Long userId);

}
