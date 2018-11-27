package com.moviecentral.dao;

import com.moviecentral.pojos.Movie;
import com.moviecentral.pojos.MoviesPlayed;
import com.moviecentral.pojos.MoviesPlayedEmbeddedClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
/*public interface MoviesPlayedDao extends JpaRepository<MoviesPlayed, MoviesPlayedEmbeddedClass> {

    //long countByMoviesPlayedEmbeddedClass_WatchedTime(Movie movie);\
    List<MoviesPlayed> findByMoviesPlayedEmbeddedClass_Movie(Movie movie);

}*/
@Transactional
@Component
public  class MoviesPlayedDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveMovieDAO(MoviesPlayed moviesPlayed) {

        entityManager.persist(moviesPlayed);

    }

    public List<Object> getMoviesList(Movie movie)
    {
        List<Object> listMovies = null;
        Object ob = null;
        try
        {
            Query query =  entityManager.createNamedQuery("MoviesPlayed.getMoviesCount");
            listMovies = query.getResultList();
            System.out.println("Hi : "+listMovies);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return listMovies;
    }
}
