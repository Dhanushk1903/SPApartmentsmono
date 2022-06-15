package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Food {
	@Id
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
	
}


