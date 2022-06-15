package com.main.dto;

import java.util.ArrayList;
import java.util.List;

import com.main.entity.Room;

import lombok.Data;

@Data
public class RoomDTO {
	private int rid;
	private String roomType;
	private long rent;
	private int noofRooms;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public long getRent() {
		return rent;
	}
	public void setRent(long rent) {
		this.rent = rent;
	}
	public int getNoofRooms() {
		return noofRooms;
	}
	public void setNoofRooms(int noofRooms) {
		this.noofRooms = noofRooms;
	}

//	convert dto to entity
	public static Room convert(RoomDTO rdto) {
		Room r1= new Room();
		r1.setNoofRooms(rdto.getNoofRooms());
		r1.setRent(rdto.getRent());
		r1.setRid(rdto.getRid());
		r1.setRoomType(rdto.getRoomType());
		return r1;
		}
	
	public static List<RoomDTO> copy(List<Room> rentity) {

		RoomDTO rdto=new RoomDTO();
		List<RoomDTO> listrdto= new ArrayList<>();
		for(int i=0;i<rentity.size();i++)
		{
			Room r1= rentity.get(i);
			rdto=rdto.entitytodto(r1);
		
			listrdto.add(rdto);
		}
		return listrdto;
	}

//	entity to dto conversion
	public static  RoomDTO entitytodto(Room r) {
		RoomDTO rdto= new RoomDTO();
		rdto.setNoofRooms(r.getNoofRooms());
		rdto.setRent(r.getRent());
		rdto.setRid(r.getRid());
		rdto.setRoomType(r.getRoomType());
		return rdto;
	}
	@Override
	public String toString() {

		return this.roomType+this.noofRooms+this.rent;
	}
	
}
