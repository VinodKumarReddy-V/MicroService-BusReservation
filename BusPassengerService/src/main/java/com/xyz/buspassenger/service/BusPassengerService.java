package com.xyz.buspassenger.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.buspassenger.exception.BusPassengerNotFound;
import com.xyz.buspassenger.model.BusPassenger;
import com.xyz.buspassenger.repository.BusPassengerRepository;

//Business logic 
@Service
public class BusPassengerService {
	
	@Autowired
	BusPassengerRepository   repositoryBusDb;

	public BusPassenger saveTicketInforamtion(BusPassenger buspassenger) throws BusPassengerNotFound {
		
		Optional<BusPassenger>  tickObj = repositoryBusDb.findById(buspassenger.getTicketNumber());
		
		if (tickObj.isPresent()) {
			
			throw new BusPassengerNotFound("Ticket "+ buspassenger.getTicketNumber() + " is already present in Can you please Create/Change another ticket number ");
		}
		else {
			return repositoryBusDb.save(buspassenger);
		}
	}

	public BusPassenger viewPassengerTicket(Integer ticketNum) throws BusPassengerNotFound {

		Optional<BusPassenger>  tikObj = repositoryBusDb.findById(ticketNum);
		
		if (tikObj.isPresent()) {
			
			return tikObj.get();
		} else {
			
			throw new BusPassengerNotFound(" Ticket Number is not exist in DB for - "+ ticketNum);
		}

	}

	public BusPassenger updateMobNumber(BusPassenger passengermob) throws BusPassengerNotFound {
		
		Optional<BusPassenger>  tikObj = repositoryBusDb.findById(passengermob.getTicketNumber());
		
		if (tikObj.isPresent()) {
			
			BusPassenger   ticketObj1 = tikObj.get();
			
			ticketObj1.setMobileNumber(passengermob.getMobileNumber());
			
			return repositoryBusDb.save(ticketObj1);
		}
		else
		{
			throw new BusPassengerNotFound("Given passenger is not present in DB , So try Again ");
		}
	
	}

	public BusPassenger cancelPassengerTicket(Integer ticketNum) throws BusPassengerNotFound {
		
		
	Optional<BusPassenger>  tikObj = repositoryBusDb.findById(ticketNum);
		
		if (tikObj.isPresent()) {
			
			repositoryBusDb.deleteById(ticketNum);
		
			return tikObj.get();
		}
		else
		{
			throw new BusPassengerNotFound("Given Ticket is not present in DB , So try Again ");
		}

	} 

}
