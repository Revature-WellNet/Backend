package com.revature.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repos.PostRepository;

@Service
public class PostService {
	

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	public List<Post> findAllPost(){
		return postRepository.findAll();
	}
	
	public Post findPostById(int id){
		return postRepository.getById(id);
	}
	
	public Post addPost(Post p) {
//		Post post = new Post();
//		post.setPosted();
//		post.setAuthor(p.getAuthor());
//		post.setComments(p.getComments());
		return postRepository.save(p);
	}
	
	public void updatePost(Post post) {
		postRepository.save(post);
	}
	
	public void deletePost(Post post) {
		postRepository.delete(post);
	}
}
