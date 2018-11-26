/**
 * 
 */
package com.moviecentral.pojos;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ravitejakommalapati
 *
 */
@Embeddable
public class MovieRatingKey {
	
	
	

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="username")
	private User user;

}
