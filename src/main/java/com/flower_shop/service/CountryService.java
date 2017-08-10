package com.flower_shop.service;

import java.util.List;

import com.flower_shop.entity.Country;



public interface CountryService {

	void save(Country country) throws Exception;

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country);
}
