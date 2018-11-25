/**
 * 
 */
package com.moviecentral.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ravitejakommalapati
 *
 */
@Entity
@Table(name="movies")
public class Movie {
	@Id
	@Column(name="movieid")
	private String movieid;
	@Column(name="title")
	private String title;
	@Column(name="genre")
	private String genre;
	@Column(name="releasedate")
	private String releasedate;
	@Column(name="studio")
	private String studio;
	@Column(name="synopsis")
	private String synopsis;
	@Column(name="image")
	private String image;
	@Column(name="movieurl")
	private String movieurl;
	@Column(name="actors")
	private String actors;
	@Column(name="director")
	private String director;
	@Column(name="country")
	private String country;
	@Column(name="rating")
	private String rating;
	@Column(name="availability")
	private String availability;
	@Column(name="price")
	private String price;
	
	
	
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMovieurl() {
		return movieurl;
	}
	public void setMovieurl(String movieurl) {
		this.movieurl = movieurl;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
