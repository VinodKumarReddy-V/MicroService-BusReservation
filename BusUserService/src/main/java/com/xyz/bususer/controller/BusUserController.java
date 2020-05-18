package com.xyz.bususer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.bususer.exception.BusRouteNotFound;
import com.xyz.bususer.model.BusUser;
import com.xyz.bususer.service.BusUserService;

@RestController
@RequestMapping("/api/User")
public class BusUserController {
	
	@Autowired
	BusUserService    service;
	
	//1.Search the bus information from DB based on source and destination 
	@GetMapping("/searchBus/{srcCity}/{destnCity}")
	public ResponseEntity<List<BusUser>>  serchBusDetails(@PathVariable ("srcCity") String sourceCity,
													@PathVariable ("destnCity") String destinationCity) throws BusRouteNotFound{
				
		List<BusUser>    busObj = service.getBusRouteDetails(sourceCity,destinationCity);
		
		
		return new ResponseEntity<List<BusUser>>(busObj, HttpStatus.FOUND);
		
	}
}
