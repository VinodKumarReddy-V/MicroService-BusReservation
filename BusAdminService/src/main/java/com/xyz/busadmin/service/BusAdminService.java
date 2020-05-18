package com.xyz.busadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.busadmin.exception.BusRouteNotFound;
import com.xyz.busadmin.model.BusAdmin;
import com.xyz.busadmin.repository.BusAdminRepository;

//Writing business logic in service
@Service
public class BusAdminService {

	@Autowired
	BusAdminRepository repositBusDb;

	public BusAdmin saveBusRoutesOrUpdate(BusAdmin busadminDtls) {
		
		Optional<BusAdmin>  obj1 = repositBusDb.findById(busadminDtls.getRouteNumber());
		
		if (obj1.isPresent()) {
			
			BusAdmin busObj = obj1.get();
			
			//busObj.setRouteNumber(busadminDtls.getRouteNumber());
			busObj.setSourceCity(busadminDtls.getSourceCity());
			busObj.setDestinationCity(busadminDtls.getSourceCity());
			busObj.setStatus(busadminDtls.getStatus());
			
			return repositBusDb.save(busObj);
			
		}
		else {
			return repositBusDb.save(busadminDtls);
		}
		
		
		
	}

	public BusAdmin getBusRouteDetails(Integer id) throws BusRouteNotFound {
		
		Optional<BusAdmin> busObj = repositBusDb.findById(id);
		
		if (busObj.isPresent()) {
			
			return busObj.get();
		}
		else
		{
			throw new BusRouteNotFound("Bus Route is not availabel for the given  "+ id);
			
		}
	
	}

	public BusAdmin deleteBusRouteDetails(Integer id) throws BusRouteNotFound {
		
		Optional<BusAdmin>   busObj = repositBusDb.findById(id);
		
		if (busObj.isPresent()) {
			
			 repositBusDb.deleteById(id);
			 
			 return busObj.get();
		}
		else
		{
			throw new BusRouteNotFound(" Route Number is not availbe in the DB for" + id);
		}
		

	}



	public List<BusAdmin> getAllBusRouteDetails() throws BusRouteNotFound {
		
		List<BusAdmin>  bObj = repositBusDb.findAll();
		
		if (bObj.isEmpty()){
			
			throw new BusRouteNotFound("No routes are present in DB" );
		}
		else
		{
			return bObj;
		}
	}

	public BusAdmin insertBusRoutesOrUpdate(BusAdmin busadminDtls) throws BusRouteNotFound {
		
		Optional<BusAdmin>  bsObj = repositBusDb.findById(busadminDtls.getRouteNumber());
		
		if (bsObj.isPresent()) {
			
			throw new BusRouteNotFound("Given bus route number already exists in DB , If u want to update use /saveBusRoute !!!  ");
		}
		else {
			 return repositBusDb.save(busadminDtls);
		}
	}

	
	
}
