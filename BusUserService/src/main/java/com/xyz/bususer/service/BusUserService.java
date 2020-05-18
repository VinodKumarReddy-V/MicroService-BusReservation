package com.xyz.bususer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.bususer.exception.BusRouteNotFound;
import com.xyz.bususer.model.BusUser;
import com.xyz.bususer.repository.BusUserRepository;

@Service
public class BusUserService {
	
	@Autowired
	BusUserRepository   repositDb;

	public List<BusUser> getBusRouteDetails(String sourceCity, String destinationCity) throws BusRouteNotFound {
		
		List<BusUser>  busObj = repositDb.findBySourceCityAndDestinationCity(sourceCity, destinationCity);
		
		if (busObj.isEmpty()) {
			
			throw new BusRouteNotFound("The given search Buses are not avilable ");
			
		}
		else
		{
			return busObj;
		}
	}
	
	

}
