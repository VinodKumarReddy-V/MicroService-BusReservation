package com.xyz.busadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.busadmin.model.BusAdmin;

@Repository
public interface BusAdminRepository extends JpaRepository<BusAdmin, Integer> {

}
