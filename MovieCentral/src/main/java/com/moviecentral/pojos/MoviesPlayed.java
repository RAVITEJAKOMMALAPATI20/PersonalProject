package com.moviecentral.pojos;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies_played")
@NamedQueries({
        @NamedQuery(
                name = "MoviesPlayed.getMovieNumberOfPlays",
                query = "select MP.moviesPlayedEmbeddedClass.movie, count(MP.moviesPlayedEmbeddedClass.user) " +
                        "from MoviesPlayed MP where MP.moviesPlayedEmbeddedClass.watchedTime > : starttime and MP.moviesPlayedEmbeddedClass.watchedTime< : endtime group by MP.moviesPlayedEmbeddedClass.movie order by count(MP.moviesPlayedEmbeddedClass.user) desc"
        ),
        @NamedQuery(
                name = "MoviesPlayed.saveMoviePlay",
                query = "select MP  " +
                        "from MoviesPlayed MP where MP.moviesPlayedEmbeddedClass.watchedTime > : starttime and MP.moviesPlayedEmbeddedClass.watchedTime< : endtime group by MP.moviesPlayedEmbeddedClass.movie "
        ),
        @NamedQuery(
                name = "MoviesPlayed.getData",
                query = "select MP  " +
                        "from MoviesPlayed MP where MP.moviesPlayedEmbeddedClass.user = : user and MP.moviesPlayedEmbeddedClass.movie= : movie and MP.moviesPlayedEmbeddedClass.watchedTime> :starttime and  MP.moviesPlayedEmbeddedClass.watchedTime< :endtime order by watched_time desc"
                        
        ),
        @NamedQuery(
                name = "MoviesPlayed.toptenusersbyplaycount",
                query = "select MP.moviesPlayedEmbeddedClass.user  ,count(MP.moviesPlayedEmbeddedClass.movie)" +
                        "from MoviesPlayed MP where MP.moviesPlayedEmbeddedClass.watchedTime > : starttime and MP.moviesPlayedEmbeddedClass.watchedTime< : endtime group by MP.moviesPlayedEmbeddedClass.user order by count(MP.moviesPlayedEmbeddedClass.movie) desc"
                        
        ),
        @NamedQuery(
                name = "MoviesPlayed.getMoviePlayCount",
                query = "select MP.moviesPlayedEmbeddedClass.movie, count(MP.moviesPlayedEmbeddedClass.user) " +
                        "from MoviesPlayed MP where MP.moviesPlayedEmbeddedClass.watchedTime > : starttime and MP.moviesPlayedEmbeddedClass.watchedTime< : endtime and MP.moviesPlayedEmbeddedClass.movie= : movie"
        ),
        
        
})
@Getter @Setter @NoArgsConstructor
public class MoviesPlayed {

    @EmbeddedId
    private MoviesPlayedEmbedded moviesPlayedEmbeddedClass;

	public MoviesPlayedEmbedded getMoviesPlayedEmbeddedClass() {
		return moviesPlayedEmbeddedClass;
	}

	public void setMoviesPlayedEmbeddedClass(MoviesPlayedEmbedded moviesPlayedEmbeddedClass) {
		this.moviesPlayedEmbeddedClass = moviesPlayedEmbeddedClass;
	}
    

}

