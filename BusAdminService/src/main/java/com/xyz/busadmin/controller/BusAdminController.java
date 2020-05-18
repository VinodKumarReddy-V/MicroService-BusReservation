package com.xyz.busadmin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.busadmin.exception.BusRouteNotFound;
import com.xyz.busadmin.model.BusAdmin;
import com.xyz.busadmin.service.BusAdminService;

@RestController
@RequestMapping("/api/Admin")
public class BusAdminController {
	
	@Autowired
	BusAdminService  service;
	
	//1. Save information of available routes 
	//3. Update Bus routes if route is available .. Here we can use PUT mapping also
	@PostMapping("/saveBusRoute")
	public ResponseEntity<BusAdmin>  saveBusDetails(@RequestBody  BusAdmin  busadminDtls){
		
		BusAdmin  busObj = service.saveBusRoutesOrUpdate(busadminDtls);
		
		return new ResponseEntity<BusAdmin>(busObj, HttpStatus.ACCEPTED);
		
		
	}
	
	//2 . View saved details based on route number 
	@GetMapping("/getBusRoute/{id}")
	public ResponseEntity<BusAdmin> viewBusdetails(@PathVariable ("id") Integer id ) throws BusRouteNotFound{
		
		BusAdmin busObj = service.getBusRouteDetails(id);
		
		return new ResponseEntity<BusAdmin>(busObj, HttpStatus.FOUND);
		
	}
	
	//4. Delete a saved information
	@DeleteMapping("/deleteBusRoute/{id}")
	public ResponseEntity<BusAdmin> deleteBusdetails(@PathVariable ("id") Integer id ) throws BusRouteNotFound{
		
		BusAdmin busObj = service.deleteBusRouteDetails(id);
		
		return new ResponseEntity<BusAdmin>(busObj, HttpStatus.FOUND);
		
	}
	
	//5. View saved information for all the buses // need to use List for all data
	@GetMapping("/getAllBusRoute")
	public ResponseEntity<List<BusAdmin>> viewAllBusdetails() throws BusRouteNotFound{
		
		List<BusAdmin> busObj = service.getAllBusRouteDetails();
		
		return new ResponseEntity<List<BusAdmin>>(busObj, HttpStatus.FOUND);
		
	}
	
	// 6. Insert the bus routes if not present in DB , If it exists just throw an exception
	@PostMapping("/insertBusRoute")
	public ResponseEntity<BusAdmin>  insertBusDetails(@RequestBody  BusAdmin  busadminDtls) throws BusRouteNotFound{
		
		BusAdmin  busObj = service.insertBusRoutesOrUpdate(busadminDtls);
		
		return new ResponseEntity<BusAdmin>(busObj, HttpStatus.ACCEPTED);
		
		
	}

}
