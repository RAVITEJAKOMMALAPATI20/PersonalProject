/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieElastic;
import com.moviecentral.services.MovieElasticService;
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
	
	@Autowired
	MovieElasticService movieElasticService;
	
	@PostMapping("/savemovie")
	public Movie savemovie(@RequestBody Movie movie,WebRequest request) {
		System.out.println(movie.getActors());
		Movie resmovie  = movieService.saveMovieService(movie);
		
		movieElasticService.saveMovieService(resmovie);
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
	@GetMapping("/getmovie")
	public Optional<MovieElastic> getMovieController(String id){
		
		Optional<MovieElastic> res=movieElasticService.getMovieService(id);
		return res;
	}
	
	@GetMapping("/getallmovies")
	public List<Movie> getmovies(WebRequest request) {
		List<Movie> resmovies=movieService.getAllMovies();
		return resmovies;
	}
	
	
	@GetMapping("/getmoviescontains")
	public List<MovieElastic> getmoviescontains(@RequestParam("text")String text) {
		List<MovieElastic> resmovies=movieElasticService.getmoviescontains(text);
		return resmovies;
	}
	
	@GetMapping("/getmovieswithgenre")
	public List<MovieElastic> getAllwithGenre(@RequestParam("text")String text) {
		List<MovieElastic> resmovies=movieElasticService.getAllwithGenre(text);
		return resmovies;
	}
}
