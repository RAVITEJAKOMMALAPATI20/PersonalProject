/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieRating;
import com.moviecentral.services.MovieRatingService;

/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/movierating")
public class MovieRatingController {
	
	@Autowired
	MovieRatingService movieRatingService;
	
	@PostMapping("/saverating")
	public MovieRating saverating(@RequestBody MovieRating movieRating,WebRequest request) {
		MovieRating resMovieRating = movieRatingService.saveratingService(movieRating);
		return resMovieRating;
	}
	
	@GetMapping("/gettopmovies")
	public List<Object> getTopTenMovies() {
		List<Object>  resmovies = movieRatingService.getTopTenMoviesService();
		return resmovies;
	}

}
