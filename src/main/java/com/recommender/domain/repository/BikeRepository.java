package com.recommender.domain.repository;

import com.recommender.domain.model.Bike;
import com.recommender.domain.model.BikeQuality;
import com.recommender.domain.model.BikeSize;
import com.recommender.domain.model.BikeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    Optional<Bike> findByTypeAndQualityAndSize(BikeType type, BikeQuality quality, BikeSize size);

    @Query(value = "SELECT * FROM BIKE bike "
            + "GROUP BY bike.id "
            + "ORDER BY (" +
            "SELECT COUNT(recommendation.id) FROM BIKE_RECOMMENDATION recommendation " +
            "WHERE recommendation.bike_id = bike.id) " +
            "DESC LIMIT :top", nativeQuery = true)
    List<Bike> findTopBikes(Integer top);

}
