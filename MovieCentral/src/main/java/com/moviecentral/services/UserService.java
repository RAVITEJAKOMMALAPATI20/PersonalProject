/**
 * 
 */
package com.moviecentral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.UserDAO;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.User;
import com.moviecentral.utils.MovieCentralMailingUtil;
import com.moviecentral.utils.MovieCentralUtil;

/**
 * @author ravitejakommalapati
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private MovieCentralUtil movieCentralUtil;
	
	@Autowired
	private MovieCentralMailingUtil movieCentralMailingUtil;
	
	
	public void signinUserService(User user) throws MovieCentralRepositoryException, MovieCentralValidationException {
		
		//Null Checks for important data
		if(user==null || user.getEmail() == null || user.getUserName() == null || user.getPassword() == null) {
			throw new MovieCentralValidationException("The data you entered is invalid");
		}
		
		if(!movieCentralUtil.validateEmail(user.getEmail())){
			
			throw new MovieCentralValidationException("The data you entered is invalid");
		}
		
		//Encoding the String password using BCryptPasswordEncoder
		String encodedpassword = movieCentralUtil.encodePassword(user.getPassword());
		
		user.setPassword(encodedpassword);
		movieCentralMailingUtil.confirmRegistration(user.getEmail());
		//userDao.signinUserDao(user);
	}
}
