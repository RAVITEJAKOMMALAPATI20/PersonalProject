/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author ravitejakommalapati
 *
 */


@Entity
@Table(name="movierating")


@NamedQueries({
	@NamedQuery(
	name = "MovieRating.getSingleRating",
	query = "select U from MovieRating U where U.user = :user AND U.movie = :movie"
	)
	,
	@NamedQuery(
			name = "MovieRating.getTopTenMovies",
			query = "select  U.movie, sum(U.rating)/count(U.user),count(U.user) from MovieRating U\n" + 
					" where U.ratedon > :startdate  and U.ratedon < :enddate  \n" + 
					"group by U.movie \n" + 
					"order by sum(U.rating)/count(U.user) desc \n"
			)
})
public class MovieRating implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2079781906167547762L;

	@Id
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User user;
	
	@Column(name="rating")
	private double rating;
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getRatedon() {
		return ratedon;
	}

	public void setRatedon(Date ratedon) {
		this.ratedon = ratedon;
	}

	@Column(name="review")
	private String review;
	
	@Column(name="ratedon")
	private Date ratedon;

	
	
}
