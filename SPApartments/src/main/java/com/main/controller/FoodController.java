package com.main.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.FoodDTO;

import com.main.exception.EmptyInputException;
import com.main.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	@Autowired
	FoodService foodService;
	Log logger = LogFactory.getLog(this.getClass());
	
	@PostMapping("/savefood")
	public FoodDTO  savefood(@RequestBody FoodDTO foodDTO) throws EmptyInputException {
		logger.info("Profile request for food"+"  "+foodDTO);
		return foodService.savefood(foodDTO);
		}
	
	@GetMapping("/allfood")
	public List<FoodDTO> getall(){
		logger.info("Get request for all food");
		return foodService.getall();
		
	}
	
	@GetMapping("/getfood/{fid}")
	public FoodDTO getspecificFood(@PathVariable ("fid") String fid) {
		logger.info("Profile request for specific food"+"  "+fid);
		return foodService.getspecificFood(fid);
	}
	

}
