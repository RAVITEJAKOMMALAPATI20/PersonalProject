/**
 * 
 */
package com.moviecentral.pojos;

/**
 * @author ravitejakommalapati
 *
 */
public class MovieRatingResponse {

	private Movie movie;
	private String rating;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
