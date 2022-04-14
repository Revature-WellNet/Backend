package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Covid19Verification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	private Timestamp timestamp;
	private boolean covid;

	public Covid19Verification(int id, int userId, Timestamp timestamp, boolean covid) {
		super();
		this.id = id;
		this.userId = userId;
		this.timestamp = timestamp;
		this.covid = covid;
	}

	public Covid19Verification(int userId, Timestamp timestamp, boolean covid) {
		super();
		this.userId = userId;
		this.timestamp = timestamp;
		this.covid = covid;
	}

	public Covid19Verification() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(covid, id, timestamp, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Covid19Verification other = (Covid19Verification) obj;
		return covid == other.covid && id == other.id && Objects.equals(timestamp, other.timestamp)
				&& userId == other.userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isCovid() {
		return covid;
	}

	public void setCovid(boolean covid) {
		this.covid = covid;
	}

}
