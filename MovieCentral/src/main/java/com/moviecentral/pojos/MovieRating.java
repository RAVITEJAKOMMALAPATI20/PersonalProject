/**
 * 
 */
package com.moviecentral.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ravitejakommalapati
 *
 */


@Entity
@Table(name="movierating")
public class MovieRating {
	
	@Id
	@Column(name="movieid")
	private String movieid;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="lastupdateddate")
	private Date lastupdateddate;
	
	@Column(name="usersrated")
	private long usersrated;

	
	
	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	public long getUsersrated() {
		return usersrated;
	}

	public void setUsersrated(long usersrated) {
		this.usersrated = usersrated;
	}	

}
