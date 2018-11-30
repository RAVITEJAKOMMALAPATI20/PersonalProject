package com.moviecentral.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class MoviesPlayedEmbedded implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="username")
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="movieid")
    private Movie movie;

    @Column(name = "watched_time")
    @JsonFormat (pattern = "yyyy-MM-dd HH:mm:ss")
    private Date watchedTime;

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

	public Date getWatchedTime() {
		return watchedTime;
	}

	public void setWatchedTime(Date watchedTime) {
		this.watchedTime = watchedTime;
	}
    
}
