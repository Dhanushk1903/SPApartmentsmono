package com.main.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.EmptyInputException;
import com.main.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	CustomerRepo crepo;
	Log logger = LogFactory.getLog(this.getClass());

	public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmptyInputException  {
		logger.info("Creation request for Customer"+customerDTO);

//		CustomerDTO dto =null; 
//		CustomerDTO.custEntitytodto(c);
       try { 
    	   Customer c= CustomerDTO.conversion(customerDTO);
		
		crepo.save(c);
		 
	    return CustomerDTO.custEntitytodto(c);
		
	} catch (Exception e) {
		throw new EmptyInputException();

	}
   	
   
	}

	public List<CustomerDTO> getallcust() {
		logger.info("Profile request for customer");
		List<Customer> c=   crepo.findAll();
		
		return  CustomerDTO.copyonlycusttoDTO(c);
	}

	public CustomerDTO getspecificCust(String adharid) {

		try {
			Customer c=crepo.getById(adharid);
			logger.info("Profile request for specific Customer"+adharid);
			
			return CustomerDTO.custEntitytodto(c);
			
		} catch (Exception e) {

			throw new NoSuchElementException();
		}
	}

	public CustomerDTO updatespecificCust(CustomerDTO customerDTO,  String adharid ) {
		logger.info("Request for Profile update for customer"+customerDTO+adharid);

		Customer c =crepo.getById(adharid);
		c=CustomerDTO.conversion(customerDTO);
		crepo.save(c);
		 
		return CustomerDTO.custEntitytodto(c);
	}

	public Boolean deleteCust(String adharid) {
		try {
			logger.info("Delete request for customer"+adharid);
			crepo.deleteById(adharid);
			return true;
		}
		catch (Exception e) {

			return false;
		}
	
	}
	
	
	

}
