package com.flower_shop.controler;

import com.flower_shop.validator.flowerValidator.FlowerValidatorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flower_shop.entity.Country;
import com.flower_shop.entity.Flower;
import com.flower_shop.service.CountryService;
import com.flower_shop.service.FlowerService;

@Controller
public class FlowerController {

	@Autowired
	private FlowerService flowerService;
	@Autowired
	private CountryService countryService;
	
	
	
	@GetMapping("/flower")
	public String flower(Model model){
		model.addAttribute("flowers", flowerService.flowerWithCountry());
		model.addAttribute("countries", countryService.findAll());
		return "/flower";
	}
	
	@PostMapping("/flower")
	public String flower(@RequestParam String flowerName,
			             @RequestParam String flowerColor,
			             @RequestParam String flowerPrice,
			             @RequestParam int coun, Model model){
		try {
			flowerService.save(new Flower(flowerName, flowerColor, Integer.parseInt(flowerPrice)), coun);
		} catch (Exception e) {
			if(e.getMessage().equals(FlowerValidatorMessage.EMPTY_FLOWERNAME_FIELD)){
				model.addAttribute("flowerNameExeption", e.getMessage());

			}else if(e.getMessage().equals(FlowerValidatorMessage.EMPTY_COLOR_FIELD)){
				model.addAttribute("flowerColorExeption", e.getMessage());
			}
			return "/flower";
		}
		Country country = countryService.findOne(coun);
			
		return "redirect:/flower";
	}
	@GetMapping("/deleteFlower/{id}")
	public String deleteFlower(@PathVariable int id){
		
		flowerService.delete(id);
		return "redirect:/flower";
	}
	
	@GetMapping("/updateFlower/{id}")
	public String updateFlower(@PathVariable int id, Model model){
		Flower flower = flowerService.findOne(id);
		
		model.addAttribute("flowers", flower);
		return "updateFlower";
	} 
	
	@PostMapping("/updateFlower/{id}")
	public String updateFlower(@RequestParam String flowerName,
								@RequestParam String flowerColor,
								@RequestParam String flowerPrice,
								@PathVariable int id){
		
		Flower flower = flowerService.findOne(id);
		flower.setName(flowerName);
		flower.setColor(flowerColor);
		flower.setPrice(Integer.parseInt(flowerPrice));
		flowerService.update(flower);
		return "redirect:/flower";
	}
	
//	@GetMapping("/deleteFlower/{id}")
//	public String deleteCountryFromFlower(@PathVariable int id){
//		flowerService.findOne(id);
//		return "redirect:/flower";
//	}
}
