package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.DiagnosisForm;
import com.revature.models.User;

@Repository
public interface UserDAO extends JpaRepository<User,String> {

	Optional<User> findById(String id);

}
