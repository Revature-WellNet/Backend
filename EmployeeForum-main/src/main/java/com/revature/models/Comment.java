package com.revature.models;

import java.time.LocalDateTime;
import java.util.Objects;

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
	
//	@ManyToOne
//	@JoinColumn(name="userId")
	@Column
	private String authorId;
	
	@ManyToOne
	@JoinColumn(name="pId")
	private Post root;

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

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Post getRoot() {
		return root;
	}

	public void setRoot(Post root) {
		this.root = root;
	}

	public Comment(Integer cId, String body, LocalDateTime created, String authorId, Post root) {
		super();
		this.cId = cId;
		this.body = body;
		this.created = created;
		this.authorId = authorId;
		this.root = root;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, body, cId, created, root);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(body, other.body)
				&& Objects.equals(cId, other.cId) && Objects.equals(created, other.created)
				&& Objects.equals(root, other.root);
	}

	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", body=" + body + ", created=" + created + ", authorId=" + authorId + ", root="
				+ root + "]";
	}

	
}
