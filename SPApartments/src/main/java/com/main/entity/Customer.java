package com.main.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Customer {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String adharid;
	@Column(nullable = false)
	private String cname;
	@Column(nullable = false)
	private String cadress;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private String phNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="r_id" ,referencedColumnName = "rid")
	
	private Room room;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adharid" , referencedColumnName = "adharid")
	private List<Food> foods;
	
	
	

	public List<Food> getFoods() {
		return foods;
	}



	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	public String
	getAdharid() {
		return adharid;
	}
	
	
	
	public void setAdharid(String adharid) {
		this.adharid = adharid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadress() {
		return cadress;
	}
	public void setCadress(String cadress) {
		this.cadress = cadress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		
		return this.adharid+this.age+this.cadress+this.cname+this.phNo;
	}
	
	
 

}
