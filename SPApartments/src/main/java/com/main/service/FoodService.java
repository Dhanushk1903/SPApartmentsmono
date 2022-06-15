package com.main.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.FoodDTO;

import com.main.entity.Food;

import com.main.exception.EmptyInputException;
import com.main.repository.FoodRepo;

@Service
public class FoodService {
	@Autowired FoodRepo foodRepo;

	public FoodDTO savefood(FoodDTO foodDTO) throws EmptyInputException {

		try {
			Food f= FoodDTO.converttoentity(foodDTO);
		foodRepo.save(f);
		
		return  foodDTO.converttodto(f);
		} catch (Exception e) {

			throw new EmptyInputException();
		} 
		
		
	}

	public List<FoodDTO> getall() {

		List<Food> f = foodRepo.findAll();
		 
		return FoodDTO.convertListDTOToEntity(f);
	}

	public FoodDTO getspecificFood(String fid) {

		try {
			Food f= foodRepo.getById(fid);
			return FoodDTO.converttodto(f);
			
			
		} catch (Exception e) {

			throw new NoSuchElementException();
		}
	
	}
	

}
