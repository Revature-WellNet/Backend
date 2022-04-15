package com.revature.repos;

import com.revature.models.Area;
import com.revature.models.Patient;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepo extends JpaRepository<Area, Integer>{

	@Query("FROM Area a WHERE a.name = ?1")
	Optional<Area> findByName(String name);
	
	
    
}
