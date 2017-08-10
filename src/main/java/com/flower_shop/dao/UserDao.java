package com.flower_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flower_shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByName(String name);
	
}
