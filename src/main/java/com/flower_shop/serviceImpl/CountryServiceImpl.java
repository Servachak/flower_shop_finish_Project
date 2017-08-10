package com.flower_shop.serviceImpl;

import java.util.List;

import com.flower_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.flower_shop.dao.CountryDao;
import com.flower_shop.entity.Country;
import com.flower_shop.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;

	@Autowired
	@Qualifier("countryValidator")
	private Validator validator;

	public void save(Country country) throws Exception {

		validator.validate(country);
		country.setName(country.getName().toUpperCase());
		countryDao.save(country);
		
	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}
	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	public void delete(int id) {
	countryDao.delete(id);
		
	}

	public void update(Country country) {
		countryDao.save(country);
		
	}

}
