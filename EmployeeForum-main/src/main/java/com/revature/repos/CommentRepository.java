package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	public Optional<Comment> findByRoot(Post root);
	
	public List<Comment> findByAuthor(User author);

}
