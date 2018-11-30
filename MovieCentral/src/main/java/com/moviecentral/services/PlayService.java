/**
 * 
 */
package com.moviecentral.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.MoviesPlayedDAO;
import com.moviecentral.dao.PlayDAO;
import com.moviecentral.pojos.PlayHistory;

/**
 * @author ravitejakommalapati
 *
 */
@Service
public class PlayService {
	
	@Autowired
	private PlayDAO playDAO;
	
	@Autowired
	private MoviesPlayedDAO moviesPlayedDAO;
	
	
public PlayHistory savePlayHistory(PlayHistory playHistory) {
	playHistory.setOndate(LocalDate.now());
	playHistory.setPlayedon(new Date());
	
	
	
	PlayHistory resPlayHistory = playDAO.savePlayHistory(playHistory);
		
		
		return resPlayHistory;
	} 
public List<PlayHistory> getUserPlayHistoryService(String username){
	List<PlayHistory> resPlayHistory=playDAO.getUserPlayHistoryDAO(username);
	return resPlayHistory;
}

public List<Object> getToptenUsersService(String duration){
	List<Object>  res= moviesPlayedDAO.getToptenUsers(duration);
	return res;
}


public List<Object> getTopMovieNumberOfPlaysService(String duration){
	List<Object>  res= moviesPlayedDAO.getTopMovieNumberOfPlays(duration);
	return res;
}

public List<Object> getMoviePlayCountService(String duration){
	List<Object>  res= moviesPlayedDAO.getMoviePlayCount(duration);
	return res;
}


}
