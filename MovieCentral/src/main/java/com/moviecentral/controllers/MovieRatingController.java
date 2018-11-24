/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieRating;

/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/movierating")
public class MovieRatingController {
	
	
	@PostMapping("/saverating")
	public Movie saverating(@RequestBody MovieRating movieRating,WebRequest request) {

		return null;
	}
	
	@GetMapping("/gettopmovies")
	public List<Movie> getTopTenMovies() {

		return null;
	}

}
