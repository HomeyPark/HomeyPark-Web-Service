package com.homeypark.web_service.reservations.infrastructure.repositories.jpa;

import com.homeypark.web_service.reservations.domain.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {}
