package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
