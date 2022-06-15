package com.main.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.CustomerDTO;


import com.main.entity.Customer;
import com.main.entity.Food;
import com.main.entity.Room;
import com.main.exception.EmptyInputException;
import com.main.repository.CustomerRepo;
import com.main.repository.RoomRepo;

@Service
public class MappedService {
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	RoomRepo roomRepo;
	private static Logger logger = LoggerFactory.getLogger("log");

	public CustomerDTO savecustomer(CustomerDTO cdto) throws EmptyInputException  {
		try {
			Customer c1 = cdto.conversion(cdto);
		
			Room r1 = new Room();
			r1.setRid(cdto.getRoomDTO().getRid());
			r1.setNoofRooms(cdto.getRoomDTO().getNoofRooms());
			r1.setRent(cdto.getRoomDTO().getRent());
			r1.setRoomType(cdto.getRoomDTO().getRoomType());
		
			List<Food> f= CustomerDTO.copyfood(cdto.getFoodDTO());
			c1.setRoom(r1);
			c1.setFoods(f);
			customerRepo.save(c1);
		}
		
		catch (Exception e) {
			
			
			throw new EmptyInputException();

		}
			return cdto;
	}

	public List<CustomerDTO> getallcust() {

		List<Customer> centity = customerRepo.findAll();
		List<CustomerDTO> cdto = CustomerDTO.copy(centity);
	
		return cdto;
	}

	public Boolean deletecust(String adharid) {

		try {
			customerRepo.deleteById(adharid);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public CustomerDTO updatecust(String adharid, CustomerDTO cdto) {

		Customer c1 = customerRepo.getById(adharid);
	  	 c1=   CustomerDTO.conversion(cdto);
		Room r1 = new Room();
		r1.setRid(cdto.getRoomDTO().getRid());
		r1.setNoofRooms(cdto.getRoomDTO().getNoofRooms());
		r1.setRent(cdto.getRoomDTO().getRent());
		r1.setRoomType(cdto.getRoomDTO().getRoomType());
		c1.setRoom(r1);
		
		List<Food> f= CustomerDTO.copyfood(cdto.getFoodDTO());
		c1.setFoods(f);
	
		customerRepo.save(c1);
		 return CustomerDTO.entitytodto(c1);
	
	  
	}

	public CustomerDTO getonecustdetails(String adharid) {

		try {
			Customer c = customerRepo.getById(adharid);
			return  CustomerDTO.entitytodto(c);
		
			
		} catch (Exception e) {

			throw new NoSuchElementException();
		}
		
		
	
}
}
