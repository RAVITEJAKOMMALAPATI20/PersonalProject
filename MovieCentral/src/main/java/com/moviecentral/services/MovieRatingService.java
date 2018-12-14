/**
 * 
 */
package com.moviecentral.services;

import java.util.Date;
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
	
	public MovieRating saveratingService(MovieRating movieRating) {
		//movie.setMovieid(movieRating.getMovieid());
		movieRating.setRatedon(new Date());
		MovieRating resmovie = movieRatingDAO.saveratingDao(movieRating);
		return resmovie;
	}
	
	public MovieRating getratingService(MovieRating movieRating) {
		MovieRating resmovie = movieRatingDAO.getratingDao(movieRating);
		return resmovie;
	}
	public List<MovieRating> getallcommentsService(MovieRating movieRating) {
	List<MovieRating> resmovie = movieRatingDAO.getallcommentDao(movieRating);
		return resmovie;
	}
	
	public List<Object> getTopTenMoviesService() {
		List<Object> topMoviesByRating=movieRatingDAO.getTopTenMoviesDao();
		return topMoviesByRating;
	}

}
