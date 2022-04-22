package com.revature.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="post")

public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pId;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private LocalDateTime posted;
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy = "root")
	private List<Comment> comments;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User author;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPosted() {
		return posted;
	}

	public void setPosted(LocalDateTime posted) {
		this.posted = posted;
	}
	
	public void setPosted() {
		this.posted = LocalDateTime.now();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Integer pId, String title, String description, LocalDateTime posted, List<Comment> comments,
			User author) {
		super();
		this.pId = pId;
		this.title = title;
		this.description = description;
		this.posted = posted;
		this.comments = comments;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", title=" + title + ", description=" + description + ", posted=" + posted
				+ ", comments=" + comments + ", author=" + author + "]";
	}
}
