package com.recommender.domain.repository;

import com.recommender.domain.model.BikeRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRecommendationRepository extends JpaRepository<BikeRecommendation, Long> {

    List<BikeRecommendation> findByUserId(Long userId);

}
