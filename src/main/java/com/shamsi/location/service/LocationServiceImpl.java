package com.shamsi.location.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamsi.location.entities.Location;

import com.shamsi.location.repos.LocationRepositoy;

@Service
public class LocationServiceImpl implements LocationService {
  @Autowired
	private LocationRepositoy repository ;
	
	public LocationRepositoy getRepository() {
		return repository;
	}

	public void setRepository(LocationRepositoy repository) {
		this.repository = repository;
	}

	@Override
	public Location saveLocation(Location location) {
		
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);

	}

	@Override
	public Optional<Location> getLocationbyId(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

}
