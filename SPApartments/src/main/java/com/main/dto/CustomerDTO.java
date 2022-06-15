package com.main.dto;

import java.util.ArrayList;
import java.util.List;



import com.main.entity.Customer;
import com.main.entity.Food;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private String adharid;
	private String cname; 
	private String cadress;
	private int age;
	private String phNo;
	private RoomDTO roomDTO;
	private List<FoodDTO> foodDTO;
	
	
	public List<FoodDTO> getFoodDTO() {
		return foodDTO;
	}
	public void setFoodDTO(List<FoodDTO> foodDTO) {
		this.foodDTO = foodDTO;
	}
	public RoomDTO getRoomDTO() {
		return roomDTO;
	}
	public void setRoomDTO(RoomDTO roomDTO) {
		this.roomDTO = roomDTO;
	}
	public String getAdharid() {
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
	
//	 converting dto to entity
	public static Customer conversion(CustomerDTO customerDTO) {
		Customer cust=new Customer();
		cust.setAdharid(customerDTO.getAdharid());
		cust.setAge(customerDTO.getAge());
		cust.setCadress(customerDTO.getCadress());
		cust.setCname(customerDTO.getCname());
		cust.setPhNo(customerDTO.getPhNo());
		return cust;
		}

//	converting entity to dto including room and food details
	public static CustomerDTO entitytodto( Customer cust) {
		CustomerDTO cdto= new CustomerDTO();
		cdto.setAdharid(cust.getAdharid());
		cdto.setAge(cust.getAge());
		cdto.setCadress(cust.getCadress());
		cdto.setCname(cust.getCname());
		cdto.setPhNo(cust.getPhNo());
	
		
		RoomDTO rdto= RoomDTO.entitytodto(cust.getRoom());
		List<FoodDTO> fdto= CustomerDTO.copyfood2(cust.getFoods());
        cdto.setRoomDTO(rdto);
        cdto.setFoodDTO(fdto);
	    return cdto;
	    }
//	converting customerentity to customerdto
	public static CustomerDTO custEntitytodto( Customer cust) {
		CustomerDTO cdto= new CustomerDTO();
		cdto.setAdharid(cust.getAdharid());
		cdto.setAge(cust.getAge());
		cdto.setCadress(cust.getCadress());
		cdto.setCname(cust.getCname());
		cdto.setPhNo(cust.getPhNo());
		return cdto;
	}
	 
//	copying one list to another list
	public static List<CustomerDTO> copy (List<Customer> centity)
	{
		List<CustomerDTO> cdto=new ArrayList<>();
		for(int i=0;i<centity.size();i++) {
		       Customer c= centity.get(i);
		       CustomerDTO c1 =CustomerDTO.entitytodto(c);
		       cdto.add(c1);
		       
		     }
	 return cdto;
		
	}
//	copying list of only customer entity to dto
	public static List<CustomerDTO> copyonlycusttoDTO (List<Customer> centity)
	{
		List<CustomerDTO> cdto=new ArrayList<>();
		for(int i=0;i<centity.size();i++) {
		       Customer c= centity.get(i);
		       CustomerDTO c1 =CustomerDTO.custEntitytodto(c);
		       cdto.add(c1);
		       
		     }
	 return cdto;
	}
	
	@Override
	public String toString() {

		return this.adharid+this.age+this.cadress+this.cname+this.phNo;
	}
	
//	copying one dtolist to another entitylist
	public static List<Food> copyfood (List<FoodDTO> fdto)
	{
		List<Food> flist=new ArrayList<>();
		for(int i=0;i<fdto.size();i++) {
			FoodDTO f1= fdto.get(i);
			Food f = FoodDTO.converttoentity(f1);
			flist.add(f);
		     }
	 return flist;
		
	}
	
//	convert foodentitylist to foodDTOlist
	public static List<FoodDTO> copyfood2 (List<Food> f)
	{
		List<FoodDTO> flist=new ArrayList<>();
		for(int i=0;i<f.size();i++) {
			Food f1= f.get(i);
			FoodDTO fdto = FoodDTO.converttodto(f1);
			flist.add(fdto);
		     }
	 return flist;
		
	}
	 
	 
	 
 
}
