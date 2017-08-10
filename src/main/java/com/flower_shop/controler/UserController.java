package com.flower_shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flower_shop.entity.User;
import com.flower_shop.service.UserService;
import com.flower_shop.validator.userRegistrationValidator.UserValidatorMessages;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("users", userService.findAll());
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@RequestParam String userName, @RequestParam String userEmail,
			@RequestParam String userPassword, @RequestParam String userSex, Model model) {

		User user = new User(userName, userPassword, userSex, userEmail);

		try {
			userService.save(user);
		} catch (Exception e) {

			if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD)
					|| e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)) {

				model.addAttribute("usernameExeptiom", e.getMessage());
			}
			return "registration";
		}
		return "redirect:/registration";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/registration";
	}

	@GetMapping("/updateUser/{id}")
	public String userUpdate(@PathVariable int id, Model model) {
		User user = userService.findOne(id);
		model.addAttribute("users", user);
		return "updateUser";

	}

	@PostMapping("/updateUser/{id}")
	public String updateUser(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String sex, @PathVariable int id) {

		User user = userService.findOne(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setSex(sex);
		userService.update(user);

		return "redirect:/registration";
	}
}
