/**
 * 
 */
package com.moviecentral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moviecentral.dao.MovieDAO;
import com.moviecentral.pojos.Movie;


/**
 * @author ravitejakommalapati
 *
 */


@Service
public class MovieService {

	
	
	@Autowired
	private MovieDAO movieDAO;
	
	
	
	public Movie saveMovieService(Movie movie) {
		Movie resmovie=movieDAO.saveMovieDAO(movie);
		
		return resmovie;
	}
	
	public void deleteMovieService(Movie movie) {
		movieDAO.deleteMovieDAO(movie);
		
	}
	public Movie updatMovieService(Movie movie) {
		Movie resMovie = movieDAO.updatMovieDAO(movie);
		
		return resMovie;
	}
	
	public List<Movie> getAllMovies() {
		
		List<Movie> resmovies =movieDAO.getAllMoviesDAO();
		return resmovies;
	}
}
