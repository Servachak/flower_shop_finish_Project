package com.flower_shop.controler;

import com.flower_shop.validator.countryValidator.CountryValidatorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flower_shop.entity.Country;
import com.flower_shop.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country")
	public String country(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "country";
	}
	
	@PostMapping("/country")
	public String county(@RequestParam String countryName
							,Model model){
		try {
			countryService.save(new Country(countryName));
		} catch (Exception e) {
			if(e.getMessage().equals(CountryValidatorMessage.EMPTY_FLOWERNAME_FIELD)){
				model.addAttribute("countryExeption", e.getMessage());
			}
			return "country";
		}

		return "redirect:/country";
	} 
	@GetMapping("deleteCountry/{id}")
	public String deleteCountry(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/country";
	}
	@GetMapping("/updateCountry/{id}")
	public String updateCountry(@PathVariable int id, Model model){
		Country country = countryService.findOne(id);
		model.addAttribute("countries", country);
		
		return "updateCountry";
	}
	@PostMapping("/updateCountry/{id}")
	public String updatrCountry(@RequestParam String name,
								@PathVariable int id){
		
		Country country = countryService.findOne(id);
		country.setName(name);
		countryService.update(country);
		return "redirect:/country";
		
	}
}
