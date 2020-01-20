package com.shamsi.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shamsi.location.entities.Location;

public interface LocationRepositoy extends JpaRepository<Location, Integer> {
	
	
	

}
