package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Comment;
import com.revature.models.User;
import com.revature.repos.CommentRepository;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins ="http;//localhost:4200")
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Comment> findAllComments() {
		return commentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Comment>> findCommentById(@PathVariable Integer id) {
		Optional<Comment> comment = commentRepository.findById(id);
		return ResponseEntity.ok().body(comment);
	}

	
	@GetMapping("user/{user}")
	public List<Comment> findCommentByUser(@PathVariable User user) {
		return commentRepository.findByAuthor(user);
	}

	@PostMapping("/add")
	public ResponseEntity<Comment> addComment(@RequestBody Comment c) {
		commentRepository.save(c);
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment c) {
		Comment comment = commentRepository.findById(id).get();
		comment.setAuthor(c.getAuthor());
		comment.setBody(c.getBody());
		comment.setCreated();
		comment.setRoot(c.getRoot());
		Comment updatedComment = commentRepository.save(comment);
		return ResponseEntity.ok(updatedComment);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteComment(@PathVariable(value = "id") Integer id) {
		Comment comment = commentRepository.findById(id).get();
		commentRepository.delete(comment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
