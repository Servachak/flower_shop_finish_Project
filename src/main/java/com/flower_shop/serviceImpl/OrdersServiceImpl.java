package com.flower_shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flower_shop.dao.OrderDao;
import com.flower_shop.entity.Orders;
import com.flower_shop.entity.User;
import com.flower_shop.service.OrderService;

@Service
public class OrdersServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	public void save(Orders orders) {
		orderDao.save(orders);
		
	}

	public List<Orders> findAll() {
		
		return orderDao.findAll();
	}

	public Orders findOne(int id) {
		
		return orderDao.findOne(id);
	}

	public void delete(int id) {
	    orderDao.delete(id);
		
	}

	public void update(Orders orders) {
		orderDao.save(orders);
		
	}

}
