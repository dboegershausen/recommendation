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
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    public List<Bike> topBikes(Integer top) {
        return bikeRepository.findTopBikes(top);
    }

    @Transactional
    public Bike createIfNotExists(Bike bike) {
        Optional<Bike> optionalBike = bikeRepository.findByTypeAndQualityAndSize(bike.getType(),
                bike.getQuality(), bike.getSize());
        if (optionalBike.isPresent()) {
            return optionalBike.get();
        } else {
            return bikeRepository.save(bike);
        }
    }

}
