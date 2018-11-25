/**
 * 
 */
package com.moviecentral.services;

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
		
		
		return null;
	}
	
	public void deleteMovieService(Movie movie) {
		
		
	}
	public Movie updatMovieService(Movie movie) {
		
		
		return null;
	}
	
	public Movie getAllMovies() {
		
		
		return null;
	}
}
