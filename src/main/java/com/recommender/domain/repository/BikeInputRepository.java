package com.recommender.domain.repository;

import com.recommender.domain.model.BikeInput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeInputRepository extends JpaRepository<BikeInput, Long> {
}
