package com.xyz.buspassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.buspassenger.exception.BusPassengerNotFound;
import com.xyz.buspassenger.model.BusPassenger;
import com.xyz.buspassenger.service.BusPassengerService;

@RestController
@RequestMapping("/api/Passenger")
public class BusPassengerController {
	
	@Autowired
	BusPassengerService    service;
	
	//1. Save information by booking a ticket
	@PostMapping("/ticketSave")
	public ResponseEntity<BusPassenger> saveTicketInfo(@RequestBody BusPassenger  buspassenger) throws BusPassengerNotFound{
		
		BusPassenger  ticketObj = service.saveTicketInforamtion(buspassenger);
		
		return new ResponseEntity<BusPassenger>(ticketObj, HttpStatus.ACCEPTED);
	}
	//2. View Saved information with ticket id
	@GetMapping("/ticketView/{id}")
	public ResponseEntity<BusPassenger> getTicketInfo(@PathVariable ("id") Integer ticketNum) throws BusPassengerNotFound{
		
		BusPassenger  tObj = service.viewPassengerTicket(ticketNum);
		
		return new ResponseEntity<BusPassenger>(tObj, HttpStatus.FOUND);
		
	}
	//3. Passenger Can only update  his mobile id
	@PutMapping("/ticketUpdateMob")
	public ResponseEntity<BusPassenger> updateMobPassenger(@RequestBody BusPassenger  passengermob) throws BusPassengerNotFound{
		
		BusPassenger  mobObj = service.updateMobNumber(passengermob);
		
		return new ResponseEntity<BusPassenger>(mobObj, HttpStatus.ACCEPTED);
	}
	
	//4. Passenger can cancel his ticket by deleting based on ticket number
	@DeleteMapping("/ticketCancel/{id}")
	public ResponseEntity<BusPassenger> cancelTicketInfo(@PathVariable ("id") Integer ticketNum) throws BusPassengerNotFound{
		
		BusPassenger  tObj = service.cancelPassengerTicket(ticketNum);
		
		return new ResponseEntity<BusPassenger>(tObj, HttpStatus.FOUND);
		
	}
}
