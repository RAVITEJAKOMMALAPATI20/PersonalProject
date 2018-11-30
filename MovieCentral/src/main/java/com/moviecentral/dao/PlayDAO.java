/**
 * 
 */
package com.moviecentral.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.moviecentral.pojos.MoviesPlayed;
import com.moviecentral.pojos.MoviesPlayedEmbedded;
import com.moviecentral.pojos.PlayHistory;

/**
 * @author ravitejakommalapati
 *
 */

@Repository
@Transactional
@Component
public class PlayDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	MoviesPlayedDAO moviesPlayedDAO;
	
	public List<PlayHistory> getPlayHistory(String username,int Duration){
		List<PlayHistory> resHistory = null;
		
		return resHistory;
	}
	
	
	public PlayHistory savePlayHistory(PlayHistory playHistory) {
		List<PlayHistory> listPlayHistory= null;
		TypedQuery<PlayHistory> query = entityManager.createNamedQuery("PlayHistory.find_usermovie_entrybydate",PlayHistory.class);
		
		query.setParameter("user",playHistory.getUser() );
		query.setParameter("movie", playHistory.getMovie());
		query.setParameter("ondate", LocalDate.now());
		
		listPlayHistory = query.getResultList();
		if(listPlayHistory!=null&&listPlayHistory.size()>0) {
			System.out.println("Merging Play History");
			playHistory.setId(listPlayHistory.get(0).getId());
			entityManager.merge(playHistory);
		}else {
			System.out.println("Persisting Play History");
			entityManager.persist(playHistory);
		}
		playHistory =query.getResultList().get(0);
		
		//Need to create new method for this moviesPlayedDAO call
		MoviesPlayed moviesPlayed =new MoviesPlayed();
		MoviesPlayedEmbedded moviesPlayedEmbedded =new MoviesPlayedEmbedded();
		moviesPlayedEmbedded.setMovie(playHistory.getMovie());
		moviesPlayedEmbedded.setUser(playHistory.getUser());
		moviesPlayedEmbedded.setWatchedTime(playHistory.getPlayedon());
		moviesPlayed.setMoviesPlayedEmbeddedClass(moviesPlayedEmbedded);
		moviesPlayedDAO.saveMovieDAO(moviesPlayed);
		entityManager.flush();
		return playHistory;
	}
	
public List<PlayHistory> getUserPlayHistoryDAO(String  username) {
		List<PlayHistory> listPlayHistory= null;
		TypedQuery<PlayHistory> query = entityManager.createNamedQuery("PlayHistory.getUserPlayHistory",PlayHistory.class);
		query.setParameter("username",username);
		listPlayHistory = query.getResultList();
		entityManager.flush();
		return listPlayHistory;
	}
	
	
	private void saveto_MoviesPlayed() {
		
	}
	
	

}
