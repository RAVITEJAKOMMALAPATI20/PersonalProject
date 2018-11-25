/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;
import java.util.Locale;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;

/**
 * @author ravitejakommalapati
 *
 */

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	
	@PostMapping("/savemovie")
	public Movie savemovie(@RequestBody Movie movie,WebRequest request) {

		return null;
	}
	@PostMapping("/deletemovie")
	public void deletemovie(@RequestBody Movie movie,WebRequest request) {

		
	}
	@PostMapping("/updatemovie")
	public Movie updatemovie(@RequestBody Movie movie,WebRequest request) {

		return null;
	}
	
	
	@PostMapping("/getmovies")
	public List<Movie> getmovies(@RequestBody Movie movie,WebRequest request) {

		return null;
	}

}
