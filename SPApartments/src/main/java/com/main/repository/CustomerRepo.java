package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{


}
