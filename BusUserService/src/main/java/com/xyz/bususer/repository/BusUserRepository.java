package com.xyz.bususer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyz.bususer.model.BusUser;


@Repository
public interface BusUserRepository extends JpaRepository<BusUser, Integer> {

	//With out writing @query it will give the results based on Column using And operator
	//1st method ..
	//List<BusUser> findBySourceCityAndDestinationCity(String sourceCity, String destinationCity);

	
	//2nd Method
	public  List<BusUser> findBySourceCityAndDestinationCity(@Param("sourceCity") String sourceCity, @Param("destinationCity") String destinationCity);
	
	
	
	// Here there is an another method we can write Query for the Custom method    NOTE : We can use above line of code or below code
	// 3rd Method ..
	// @Query("SELECT b from Bus_Routes b where b.sourceCity = :sourceCity and b.destinationCity = :destinationCity")
	//public  List<BusUser> findBySourceCityAndDestinationCity(@Param("sourceCity") String sourceCity, @Param("destinationCity") String destinationCity);
		
	}
