package com.moviecentral.dao;

import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.pojos.MoviesPlayed;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
@Component
public class MoviesPlayedDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveMovieDAO(MoviesPlayed moviesPlayed){
    	
		Date yesterdaytime = getStartDate("DAY");
    	
    	List<MoviesPlayed> listPlayHistory= null;
		TypedQuery<MoviesPlayed> query = entityManager.createNamedQuery("MoviesPlayed.getData",MoviesPlayed.class);
		query.setParameter("user", moviesPlayed.getMoviesPlayedEmbeddedClass().getUser());
		query.setParameter("movie", moviesPlayed.getMoviesPlayedEmbeddedClass().getMovie());
		query.setParameter("starttime", yesterdaytime);
		query.setParameter("endtime", moviesPlayed.getMoviesPlayedEmbeddedClass().getWatchedTime());
		query.setMaxResults(1);
		listPlayHistory = query.getResultList();
	
		if(listPlayHistory!=null&&listPlayHistory.size()>0) {
			System.out.println("Not inserting the data because 24 hours did not completed");
		}else {
			entityManager.persist(moviesPlayed);
			entityManager.flush();
		}
        
    }


public List<Object> getToptenUsers(String duration){
    List<Object> toptenUsers = null;
    try
    {
        Query query = entityManager.createNamedQuery("MoviesPlayed.toptenusersbyplaycount");
        query.setParameter("starttime", getStartDate(duration));
        query.setParameter("endtime", new Date());
        query.setMaxResults(10);
        toptenUsers = query.getResultList();
    }
    catch(Exception e)
    {
        throw new MovieCentralRepositoryException(e.getMessage());
    }
    return  toptenUsers;
}


public List<Object> getMoviePlayCount(String duration){
	
    List<Object> moviesReportList = null;
    try
    {
        Query query = entityManager.createNamedQuery("MoviesPlayed.getMovieNumberOfPlays");
        query.setParameter("starttime", getStartDate(duration));
        query.setParameter("endtime", new Date());
        moviesReportList = query.getResultList();
    }
    catch(Exception e)
    {
        throw new MovieCentralRepositoryException(e.getMessage());
    }
    return  moviesReportList;
}

public List<Object> getTopMovieNumberOfPlays(String duration){
	
    List<Object> moviesReportList = null;
    try
    {
        Query query = entityManager.createNamedQuery("MoviesPlayed.getMovieNumberOfPlays");
        query.setParameter("starttime", getStartDate(duration));
        query.setParameter("endtime", new Date());
        query.setMaxResults(10);
        moviesReportList = query.getResultList();
    }
    catch(Exception e)
    {
        throw new MovieCentralRepositoryException(e.getMessage());
    }
    return  moviesReportList;
}
    private Date getStartDate(String period) {
    	Calendar calendar = Calendar.getInstance(); 
		switch(period) {
		case "DAY":calendar.add(Calendar.DATE, -1);
			break;
		case "WEEK":calendar.add(Calendar.DATE, -7);
			break;
		case "MONTH":calendar.add(Calendar.MONTH, -1);
			break;
		}
		Date res = new Date(calendar.getTime().getTime());
    	return res;
    }
}
