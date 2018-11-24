/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;
import com.moviecentral.services.MovieService;

/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	
	@Autowired
	MovieService movieService;
	
	@PostMapping("/savemovie")
	public Movie savemovie(@RequestBody Movie movie,WebRequest request) {
		System.out.println(movie.getActors());
		Movie resmovie  = movieService.saveMovieService(movie);
		return resmovie;
	}
	@PostMapping("/deletemovie")
	public void deletemovie(@RequestBody Movie movie,WebRequest request) {
		movieService.deleteMovieService(movie);	
	}
	@PostMapping("/updatemovie")
	public Movie updatemovie(@RequestBody Movie movie,WebRequest request) {
		Movie resmovie = movieService.updatMovieService(movie);
		return resmovie;
	}
	
	
	@GetMapping("/getallmovies")
	public List<Movie> getmovies(WebRequest request) {
		List<Movie> resmovies=movieService.getAllMovies();
		return resmovies;
	}

}
