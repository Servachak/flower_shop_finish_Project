package com.flower_shop.serviceImpl;

import java.util.List;

import com.flower_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.flower_shop.dao.CountryDao;
import com.flower_shop.dao.FlowerDao;
import com.flower_shop.entity.Country;
import com.flower_shop.entity.Flower;
import com.flower_shop.service.FlowerService;

@Service
public class FlowerServiceImpl implements FlowerService{

	@Autowired
	private FlowerDao flowerDao;

	@Autowired
	private CountryDao countryDao;

	@Autowired
	@Qualifier("flowerValidator")
	private Validator validator;
	
	
	public void save(Flower flower, int coun) throws Exception {
				
		Country country = countryDao.findOne(coun);
		
		flowerDao.saveAndFlush(flower);
		
		flower.getCountrys().add(country);

		validator.validate(flower);
		flowerDao.save(flower);
		
	}

	public List<Flower> findAll() {
		return flowerDao.findAll();
	}

	public Flower findOne(int id) {
		return flowerDao.findOne(id);
	}

	public void delete(int id) {
		flowerDao.delete(id);
		
	}

	public void update(Flower flower) {
		flowerDao.save(flower);
		
	}
	public List<Flower> flowerWithCountry(){
		return  flowerDao.flowerWithCountry();
	}

	

}
