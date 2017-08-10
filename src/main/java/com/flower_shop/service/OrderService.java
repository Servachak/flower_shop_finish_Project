package com.flower_shop.service;


import java.util.List;

import com.flower_shop.entity.Orders;
import com.flower_shop.entity.User;

public interface OrderService {

	void save(Orders orders);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);
	
	
	
}