package com.flower_shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flower_shop.entity.Country;
import com.flower_shop.entity.Flower;

public interface CountryDao extends JpaRepository<Country, Integer> {

	
}
