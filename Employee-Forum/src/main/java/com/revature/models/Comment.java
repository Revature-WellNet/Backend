package com.revature.models;

import java.time.LocalDateTime;

public class Comment {
	
	private Integer cId;
	
	private String body;
	
	private LocalDateTime created;
	
	private User author;
	
	private Post origin;
	

}
