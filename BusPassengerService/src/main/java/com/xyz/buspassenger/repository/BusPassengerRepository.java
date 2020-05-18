package com.xyz.buspassenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.buspassenger.model.BusPassenger;

public interface BusPassengerRepository extends JpaRepository<BusPassenger, Integer> {

}
