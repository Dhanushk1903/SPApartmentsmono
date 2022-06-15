package com.main.dto;


import java.util.ArrayList;
import java.util.List;

import com.main.entity.Food;


public class FoodDTO {
private String fid;
private String foodtype;
private int cost;



public String getFid() {
	return fid;
}

public void setFid(String fid) {
	this.fid = fid;
}

public String getFoodtype() {
	return foodtype;
}

public void setFoodtype(String foodtype) {
	this.foodtype = foodtype;
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

//convert dto to entity
public static Food converttoentity(FoodDTO fdto) {
	Food f1 =  new Food();
	f1.setFid(fdto.getFid());
	f1.setCost(fdto.getCost());
	f1.setFoodtype(fdto.getFoodtype());
	return f1;
	}

// convert entity to dto
public static FoodDTO converttodto(Food f) {
	FoodDTO fdto = new FoodDTO();
	fdto.setCost(f.getCost());
	fdto.setFid(f.getFid());
	fdto.setFoodtype(f.getFoodtype());
	return fdto;
}

public static List<FoodDTO> convertListDTOToEntity(List<Food> foods){
	List<FoodDTO> dtos= new ArrayList<>();
	for(int i=0; i<foods.size(); i++) {
		Food f=  foods.get(i);
		FoodDTO dto= FoodDTO.converttodto(f);
		dtos.add(dto);
	}
	return dtos;
	
}


}



