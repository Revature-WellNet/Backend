package com.revature.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="post")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
	@JsonIgnore
	private List<Comment> comments;
	
//	@JoinColumn(name="userId")
//	@ManyToOne
	@Column
	private String authorId;

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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Post(Integer pId, String title, String description, LocalDateTime posted, List<Comment> comments,
			String authorId) {
		super();
		this.pId = pId;
		this.title = title;
		this.description = description;
		this.posted = posted;
		this.comments = comments;
		this.authorId = authorId;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, comments, description, pId, posted, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(comments, other.comments)
				&& Objects.equals(description, other.description) && Objects.equals(pId, other.pId)
				&& Objects.equals(posted, other.posted) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", title=" + title + ", description=" + description + ", posted=" + posted
				+ ", comments=" + comments + ", authorId=" + authorId + "]";
	}

	
}
