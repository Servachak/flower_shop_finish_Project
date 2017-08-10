package com.flower_shop.validator.userRegistrationValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flower_shop.entity.User;
import com.flower_shop.service.UserService;
import com.flower_shop.validator.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public void validate(Object o) throws Exception {

		User user = (User) o;

		if (user.getName().isEmpty()) {

			throw new UserRegistrationExeption(UserValidatorMessages.EMPTY_USERNAME_FIELD);

		} 
		else if (userService.findByName(user.getName()) != null) {

			throw new UserRegistrationExeption(UserValidatorMessages.USERNAME_ALREADY_EXIST);
		}
	}

}
