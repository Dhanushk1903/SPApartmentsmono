package com.main.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.main.dto.RoomDTO;

import com.main.entity.Room;
import com.main.exception.EmptyInputException;
import com.main.repository.RoomRepo;

@Service
public class RoomService {
	@Autowired
	RoomRepo roomRepo;

	public RoomDTO saveRoom(RoomDTO roomDTO) throws EmptyInputException {
		try {
			Room room = roomDTO.convert(roomDTO);
			roomRepo.save(room);
			return roomDTO;
			
		} catch (Exception e) {

			throw new EmptyInputException();
		}
		
		
	}

	public List<RoomDTO> getallRooms() {
		List<Room> rentity= roomRepo.findAll();
		 

		return RoomDTO.copy(rentity);
	}

	public RoomDTO updateRoom(int rid, RoomDTO roomDTO) {

	
	
		 Room r=roomRepo.getById(rid);
     	
	    r.setNoofRooms(roomDTO.getNoofRooms());
		r.setRent(roomDTO.getRent());
		r.setRoomType(roomDTO.getRoomType());
	    roomRepo.save(r);
	
		return RoomDTO.entitytodto(r);
	}

	public boolean deleteRoom(int rid) {

		try {
		roomRepo.deleteById(rid);
		
		return true;
		}
		catch (Exception e) {

		  return	false;
		}
		
	}

	public RoomDTO getspecificRoom(Integer rid) {

		try {
			Room r= roomRepo.getById(rid);
			
			return RoomDTO.entitytodto(r);
			
		} catch (Exception e) {

			throw new NoSuchElementException();
		}
		
	}
	

}
