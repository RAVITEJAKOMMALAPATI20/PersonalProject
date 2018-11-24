/**
 * 
 */
package com.moviecentral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.MovieRatingDAO;
import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieRating;

/**
 * @author ravitejakommalapati
 *
 */
@Service

public class MovieRatingService {
	
	@Autowired
	MovieRatingDAO movieRatingDAO;
	@Autowired
	Movie movie;
	
	public Movie saveratingService(MovieRating movieRating) {
		movie.setMovieid(movieRating.getMovieid());
		Movie resmovie = movieRatingDAO.saveratingDao(movieRating, movie);
		return resmovie;
	}
	
	
	public List<Movie> getTopTenMoviesService() {
		List<Movie> topMoviesByRating=movieRatingDAO.getTopTenMoviesDao();
		return topMoviesByRating;
	}

}
