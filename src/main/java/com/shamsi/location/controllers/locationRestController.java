package com.shamsi.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shamsi.location.entities.Location;
import com.shamsi.location.repos.LocationRepositoy;

@RestController 
@RequestMapping("/locations")

public class locationRestController {
	
	@Autowired
	LocationRepositoy locationRepository;
	
    @GetMapping 
    public List<Location> getLoctions(){
		return locationRepository.findAll();
    }
    @PostMapping
    public Location createLocation (@RequestBody Location location) {
    	return locationRepository.save(location); 
    }
  
    @PutMapping
    public Location UpdateLocation (@RequestBody Location location) {
    	return locationRepository.save(location); 
    }
	
    @DeleteMapping("/{id}")
    public void DeleteLocation (@PathVariable("id") int id) {
    	locationRepository.deleteById(id); 
    }
	
    @GetMapping("/{id}")
    public Optional<Location> FindOneLocation (@PathVariable("id") int id) {
    	
		return locationRepository.findById(id);
    }
    
}
