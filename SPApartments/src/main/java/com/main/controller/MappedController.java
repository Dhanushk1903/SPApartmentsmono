package com.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.CustomerDTO;
import com.main.exception.EmptyInputException;
import com.main.service.MappedService;

@RestController
@RequestMapping("/map")
public class MappedController {
	
	@Autowired
	MappedService mappedService;
	
Log logger = LogFactory.getLog(this.getClass());
	//  /map/save
	@PostMapping("/save")
	public CustomerDTO savecustomer  (@RequestBody CustomerDTO cdDto) throws EmptyInputException  {
		logger.info("Profile Creation request for Customer"+"  "+cdDto);
		return mappedService.savecustomer(cdDto);
	}

//	/map/all
	@GetMapping("/all")
	public List<CustomerDTO> getallcust()  {
		logger.info("Profile Request for all the customers");
		return mappedService.getallcust();
	}

//		/map/one/
	@GetMapping("/one/{adharid}")
	public CustomerDTO getonecustdetails(@PathVariable ("adharid") String adharid ) {
		logger.info("Profile request for specific customer"+"  "  +   adharid);
		
		return mappedService.getonecustdetails(adharid);
	}

//	/map/delete
	@DeleteMapping("delete/{adharid}")
	public Boolean deletecust(@PathVariable ("adharid") String adharid ) {
		logger.info(" request for deletion of specific customer"+"  "  +   adharid);
		return mappedService.deletecust(adharid);
		}

//	/map/update/
	@PutMapping("/update/{adharid}")
	public CustomerDTO updatecust(@PathVariable ("adharid")String adharid, @RequestBody CustomerDTO cdto) {
		logger.info("Request for updation of specific customer"+"  "  +   adharid);
		return mappedService.updatecust(adharid,cdto);
		}
	
}
