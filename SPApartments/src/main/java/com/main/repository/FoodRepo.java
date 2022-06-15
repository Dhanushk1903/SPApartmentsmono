package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Food;

public interface FoodRepo extends JpaRepository<Food, String> {

}
