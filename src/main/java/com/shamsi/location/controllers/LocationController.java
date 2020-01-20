package com.shamsi.location.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shamsi.location.entities.Location;
import com.shamsi.location.repos.LocationRepositoy;
import com.shamsi.location.service.LocationService;
import com.shamsi.location.util.EmailUtil;



@Controller
public class LocationController {
	@Autowired
	LocationService service;
	@Autowired
	LocationRepositoy repository;
	@Autowired
	EmailUtil emailUtil;
	

	@GetMapping("/create")
	public String showCreate() {
		System.out.println("work");
		return "CreateLocation";
	}

	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("chamsjlassi2@gmail.com", "chamous houni", "i love u beautiful");
		return "CreateLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "DisplayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "DisplayLocations";

	}

	@RequestMapping("/showUpdate")

	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Optional<Location> location = service.getLocationbyId(id);
		if (location.isPresent()) {
			modelMap.addAttribute("location", location.get());
		}

		return "UpdateLocation";
	}

	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "DisplayLocations";
	}
	
		
	}
	
	

	


