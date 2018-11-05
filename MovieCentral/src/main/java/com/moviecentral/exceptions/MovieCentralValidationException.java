/**
 * 
 */
package com.moviecentral.exceptions;

/**
 * @author ravitejakommalapati
 *
 */
public class MovieCentralValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2458956424598234985L;

	public MovieCentralValidationException(){
        super();
    }

    public MovieCentralValidationException(String message){
        super(message);
    }
}
