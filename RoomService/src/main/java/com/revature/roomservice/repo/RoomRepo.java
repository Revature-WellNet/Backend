package com.revature.roomservice.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.roomservice.model.Area;
import com.revature.roomservice.model.Patient;
import com.revature.roomservice.model.Room;
import com.revature.roomservice.model.User;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
    
	@Query("FROM Room r where r.area = ?1")
	public List<Room> findByArea(Area area);
	
	@Query("FROM Room r where r.doctor = ?1")
	public List<Room> findByDoctor(User doctor);
	
//	@Query("FROM Room r where r.nurse = ?1")
//	public List<Room> findByNurse(User nurse);
	
	@Query("FROM Room r where r.patient = ?1")
	public Room findByPatient(Patient patient);
	
}
