package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, String> {

}
