package com.flower_shop.service;

import java.util.List;

import com.flower_shop.entity.Flower;


public interface FlowerService {

	void save(Flower flower, int coun) throws Exception;

	List<Flower> findAll();

	Flower findOne(int id);

	void delete(int id);

	void update(Flower flower);
	
	List<Flower> flowerWithCountry();
}
