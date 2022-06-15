package com.main.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.dto.AdminDTO;
import com.main.entity.Admin;
import com.main.repository.AdminRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo adminRepo;
	
	Log logger = LogFactory.getLog(this.getClass());

	public AdminDTO saveadmin(AdminDTO adminDTO) {
		logger.info("Creation request for Admin {}"+adminDTO);
		Admin admin= AdminDTO.entitytoDTO(adminDTO);
		adminRepo.save(admin);
		return adminDTO;
	}

	public Boolean loginadmin(AdminDTO adminDTO) {

		 Boolean flag=false;
		Admin admin = new Admin();
		adminRepo.findById(adminDTO.getAid());
		logger.info("Login request for admin {} with password {}"+adminDTO.getAname()+adminDTO.getPassword());
		if(adminDTO.getAid() != null && adminDTO.getPassword().equals(admin.getPassword()))
		{
		return true;
		}
		else {
		return  flag;
	}
	}
}
