package com.main.controller;

import java.util.List;

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


import com.main.dto.RoomDTO;
import com.main.exception.EmptyInputException;
import com.main.service.RoomService;

@RestController
@RequestMapping("/room")

public class RoomController {
	@Autowired
	RoomService roomService;
	Log logger = LogFactory.getLog(this.getClass());

	
//  /room/save
	@PostMapping("/save")
	public RoomDTO saveRoom(@RequestBody RoomDTO roomDTO) throws EmptyInputException {
		logger.info(" request for creation of specific room"+"  "  +   roomDTO);
		return roomService.saveRoom(roomDTO);
		}
	
//	/room/getallroom
	@GetMapping("/getallroom")
	public List<RoomDTO> getallRooms(){
		logger.info(" request for getallRooms");
		return roomService.getallRooms();
	}
	
	@GetMapping("/getroom/{rid}")
	public RoomDTO getspecificRoom(@PathVariable ("rid") Integer rid) {
		logger.info("Profile request for specific room"+"  "  +   rid);
		return roomService.getspecificRoom(rid);
	}
	
//	/room/update/
	@PutMapping("/update/{rid}")
	public RoomDTO updateRoom(@PathVariable ("rid") int rid, @RequestBody RoomDTO roomDTO) {
		logger.info(" request for updation of specific room"+"  "  +   roomDTO);
		return roomService.updateRoom(rid,roomDTO);
	}
	
//	/room/delete/
	@DeleteMapping("/delete/{rid}")
	public boolean deleteRoom(@PathVariable ("rid") int rid) {
		logger.info(" request for deletion of specific room"+"  "  + rid);
		return roomService.deleteRoom(rid);
	}
	

}

