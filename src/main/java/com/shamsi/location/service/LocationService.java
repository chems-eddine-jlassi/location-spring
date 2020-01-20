package com.shamsi.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shamsi.location.entities.Location;

@Service
public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Optional<Location> getLocationbyId(int id);

	List<Location> getAllLocations();

}
