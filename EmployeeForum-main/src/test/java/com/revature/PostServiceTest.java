package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.PostRepository;
import com.revature.services.PostService;

@SpringBootTest
public class PostServiceTest {
	@InjectMocks
	private PostService postService;
	
	@Mock
	private PostRepository postRepository;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void getPostTest() {
		List<Post> post = new ArrayList<Post>();
		List<Comment> comments = new ArrayList<Comment>();
		User userNurse = new User("1", "Name", "Last", "Email", new Role(1, "nurse"));
		User userDoctor = new User("2", "Name", "Last", "Email", new Role(2, "doctor"));
		Post post1 = new Post(1, "Title for post1", "Description goes here", LocalDateTime.now(), comments, userNurse);
		Post post2 = new Post(2, "Title for post2", "Description goes here", LocalDateTime.now(), comments, userDoctor);
		Comment comment = new Comment(100, "This is a comment", LocalDateTime.now(), userNurse, post1);
		Comment comment2 = new Comment(200, "This is a second comment", LocalDateTime.now(), userDoctor, post2);
		post.add(post1);
		post.add(post2);
		comments.add(comment);
		comments.add(comment2);
		when(postRepository.findAll()).thenReturn(post);
		
		List<Post> postList = postService.findAllPost();
		
		assertEquals(2, postList.size());
		verify(postRepository, times(1)).findAll();	
		
	}
	@Test
	public void getPostByIdTest()
	{
		List<Post> posts = new ArrayList<Post>();
		List<Comment> comments = new ArrayList<Comment>();
		User userNurse = new User("1", "Name", "Last", "Email", new Role(1, "nurse"));
		Post post = new Post(1, "Title", "This is a description", LocalDateTime.now(), comments, userNurse);
		Comment comment = new Comment(100, "This is a comment", LocalDateTime.now(), userNurse, post);
		comments.add(comment);
		posts.add(post);
		when(postRepository.getById(1)).thenReturn(post);
		Post p1 = postService.findPostById(1);
		assertEquals("This is a description", p1.getDescription());
	}
	
	@Test
	public void addPostTest() {
		List<Post> posts = new ArrayList<Post>();
		List<Comment> comments = new ArrayList<Comment>();
		User userDoctor = new User("1", "Name", "Last", "Email", new Role(1, "doctor"));
		Post post = new Post(1, "This is the title", "This is a description", LocalDateTime.now(), comments, userDoctor);
		Comment comment = new Comment(200, "This is a comment", LocalDateTime.now(), userDoctor, post);
		comments.add(comment);
		posts.add(post);

		postService.addPost(post);
		verify(postRepository, times(1)).save(post);
	}
	
	@Test
	public void updatePostTest() {
		List<Post> posts = new ArrayList<Post>();
		List<Comment> comments = new ArrayList<Comment>();
		User userDoctor = new User("1", "Name", "Last", "Email", new Role(1, "doctor"));
		Post post = new Post(1, "This is the title", "This is a description", LocalDateTime.now(), comments, userDoctor);
		Comment comment = new Comment(200, "This is a comment", LocalDateTime.now(), userDoctor, post);
		comments.add(comment);
		posts.add(post);

		when(postService.findPostById(200)).thenReturn(post);
		postService.updatePost(post);
		verify(postRepository, times(1)).save(post);
	}
	@Test
	public void deletePostTest() {
		List<Post> posts = new ArrayList<Post>();
		List<Comment> comments = new ArrayList<Comment>();
		
		User userDoctor = new User("1", "Name", "Last", "Email", new Role(1, "doctor"));
		Post post = new Post(1, "This is the title", "This is a description", LocalDateTime.now(), comments, userDoctor);
		Comment comment = new Comment(200, "This is a comment", LocalDateTime.now(), userDoctor, post);
		comments.add(comment);
		posts.add(post);

		when(postService.findPostById(200)).thenReturn(post);
		postService.deletePost(post);
		verify(postRepository, times(1)).delete(post);
	}
}

