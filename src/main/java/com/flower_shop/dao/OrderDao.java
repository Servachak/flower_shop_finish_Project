package com.flower_shop.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flower_shop.entity.Flower;
import com.flower_shop.entity.Orders;
import com.flower_shop.entity.User;

public interface OrderDao extends JpaRepository<Orders, Integer>{
	

}
