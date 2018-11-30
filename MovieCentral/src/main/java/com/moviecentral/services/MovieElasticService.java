/**
 * 
 */
package com.moviecentral.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MovieElastic;
import com.moviecentral.repository.MoRepository;
import com.moviecentral.utils.SearchQueryBuilder;

/**
 * @author ravitejakommalapati
 *
 */

@Service
public class MovieElasticService {
	
	@Autowired
	private MoRepository movRepository;
	
	@Autowired
	SearchQueryBuilder searchQueryBuilder;
	
	
	public Optional<MovieElastic> saveMovieService(Movie movie) {
		MovieElastic movieElastic =createMovieElastic(movie);

		movRepository.save(movieElastic);
		Optional<MovieElastic> resmovie=movRepository.findById(movieElastic.getId());
		return resmovie;
	}
	

	public Optional<MovieElastic> getMovieService(String id) {
	
		Optional<MovieElastic> resmovie=movRepository.findById(id);
		return resmovie;
	}
	
	public List<MovieElastic> getmoviescontains(String text){
		return searchQueryBuilder.getAll(text);
	}
	
	public List<MovieElastic> getAllwithGenre(String text){
		return searchQueryBuilder.getAllwithGenre(text);
	}
	
		private MovieElastic createMovieElastic(Movie movie) {
		MovieElastic movieElastic =new MovieElastic();
		
		movieElastic.setActors(movie.getActors());
		movieElastic.setId(movie.getMovieid());
		movieElastic.setGenre(movie.getGenre());
		movieElastic.setMovieid(movie.getMovieid());
		movieElastic.setSynopsis(movie.getSynopsis());
		movieElastic.setMovieurl(movie.getMovieurl());
		movieElastic.setImage(movie.getImage());
		movieElastic.setAvailability(movie.getAvailability());
		movieElastic.setPrice(movie.getPrice());
		movieElastic.setReleasedate(movie.getReleasedate());
		movieElastic.setRating(movie.getRating());
		movieElastic.setTitle(movie.getTitle());
		movieElastic.setDirector(movie.getDirector());
		return movieElastic;
	}

}
