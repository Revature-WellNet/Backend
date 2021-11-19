package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Covid19Verifcation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Timestamp timestamp;
	private boolean covid;
	
	public Covid19Verifcation(int id, Timestamp timestamp, boolean covid) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.covid = covid;
	}

	public Covid19Verifcation(Timestamp timestamp, boolean covid) {
		super();
		this.timestamp = timestamp;
		this.covid = covid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (covid ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Covid19Verifcation other = (Covid19Verifcation) obj;
		if (covid != other.covid)
			return false;
		if (id != other.id)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Covid19Verifcation [id=" + id + ", timestamp=" + timestamp + ", covid=" + covid + "]";
	}
	
	
	
}

