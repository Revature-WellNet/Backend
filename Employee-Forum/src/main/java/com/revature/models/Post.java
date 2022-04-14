package com.revature.models;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
	
	private Integer pId;
	
	private String title;
	
	private String description;
	
	private LocalDateTime posted;
	
	private List<Comment> comments;
	
	private User author;
	

}
