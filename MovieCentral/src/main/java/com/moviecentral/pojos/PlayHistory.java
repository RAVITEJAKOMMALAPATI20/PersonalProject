/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;



/**
 * @author ravitejakommalapati
 *
 */
/**
 * 
 * @author Namrata
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(
	name = "PlayHistory.find_usermovie_entrybydate",
	query = "select P from PlayHistory P where P.user = :user AND P.movie = :movie And P.ondate = :ondate"
	),
	@NamedQuery(
			name = "PlayHistory.getUserPlayHistory", 
			query = "select P from PlayHistory P where P.user.username = :username order by playedon desc"
			)
})
@JsonSerialize
public class PlayHistory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@Column(name="playedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date playedon;
		
	@Column(name="ondate")
	private LocalDate ondate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getPlayedon() {
		return playedon;
	}

	public void setPlayedon(Date playedon) {
		this.playedon = playedon;
	}

	public LocalDate getOndate() {
		return ondate;
	}

	public void setOndate(LocalDate ondate) {
		this.ondate = ondate;
	}

	

	
	
}
