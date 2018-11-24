/**
 * 
 */
package com.moviecentral.exceptions;

/**
 * @author ravitejakommalapati
 *
 */
public class MovieCentralRepositoryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MovieCentralRepositoryException(){
        super();
        
    }

    public MovieCentralRepositoryException(String message){
        super(message);
    }

}
