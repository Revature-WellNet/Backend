package com.revature.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cId;
	
	@Column
	private String body;
	
	@Column
	private LocalDateTime created;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User author;
	
	@ManyToOne
	@JoinColumn(name="pId")
	private Post root;

	public Comment(Integer cId, String body, LocalDateTime created, User author, Post root) {
		super();
		this.cId = cId;
		this.body = body;
		this.created = created;
		this.author = author;
		this.root = root;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setCreated() {
		this.created = LocalDateTime.now();
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Post getRoot() {
		return root;
	}

	public void setRoot(Post root) {
		this.root = root;
	}

	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", body=" + body + ", created=" + created + "]";
	}
}
