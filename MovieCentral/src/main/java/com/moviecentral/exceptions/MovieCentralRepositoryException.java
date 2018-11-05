/**
 * 
 */
package com.moviecentral.exceptions;

/**
 * @author ravitejakommalapati
 *
 */
public class MovieCentralRepositoryException extends Exception{

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
