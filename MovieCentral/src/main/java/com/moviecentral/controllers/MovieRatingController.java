/**
 * 
 */
package com.moviecentral.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieRating;
import com.moviecentral.pojos.User;
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
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getrating")
	public MovieRating getrating(String movieid,String username) {
		MovieRating movierating =new MovieRating();
		User user= new User();
		Movie movie = new Movie();
		user.setUsername(username);
		movie.setMovieid(movieid);
		movierating.setMovie(movie);
		movierating.setUser(user);
		MovieRating  resrating = movieRatingService.getratingService(movierating);
		return resrating;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getallcomments")
	public List<MovieRating> getallcomments(String movieid) {
		MovieRating movierating =new MovieRating();
		Movie movie =new Movie();
		movie.setMovieid(movieid);
		movierating.setMovie(movie);
		List<MovieRating>  resrating = movieRatingService.getallcommentsService(movierating);
		return resrating;
	}
	
	@GetMapping("/gettopmovies")
	public List<Object> getTopTenMovies() {
		List<Object>  resmovies = movieRatingService.getTopTenMoviesService();
		return resmovies;
	}

}
