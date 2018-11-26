/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;
/**
 * @author ravitejakommalapati
 *
 */
@Entity
@Component
@Table(name="movies")
@NamedQueries({
	@NamedQuery(
	name = "Movie.getAllMovies",
	query = "select M from Movie M"
	)
})
public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8216953233461707887L;
	
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
	@Column(name="synopsis" ,length=1000)
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
	
	
	@Column(name="registereddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registereddate;
	
	public Date getRegistereddate() {
		return registereddate;
	}
	public void setRegistereddate(Date registereddate) {
		this.registereddate = registereddate;
	}
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
