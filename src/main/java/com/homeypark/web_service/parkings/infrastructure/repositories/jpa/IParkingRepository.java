package com.homeypark.web_service.parkings.infrastructure.repositories.jpa;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParkingRepository extends JpaRepository<Parking, Long> {
}
