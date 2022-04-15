package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Covid19Verification {
	
	@Id
	private String userId;
	private int id;
	private Timestamp timestamp;
	private boolean covid;
	
	public Covid19Verification(int id, String userId, Timestamp timestamp, boolean covid) {
		super();
		this.id = id;
		this.userId = userId;
		this.timestamp = timestamp;
		this.covid = covid;
	}

	public Covid19Verification(String userId, Timestamp timestamp, boolean covid) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + (covid ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
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
		if (covid != other.covid)
			return false;
		if (id != other.id)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

