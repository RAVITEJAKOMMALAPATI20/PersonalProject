/**
 * 
 */
package com.moviecentral.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecentral.dao.TokenDAO;
import com.moviecentral.dao.UserDAO;
import com.moviecentral.exceptions.MovieCentralRepositoryException;
import com.moviecentral.exceptions.MovieCentralValidationException;
import com.moviecentral.pojos.User;
import com.moviecentral.pojos.VerificationToken;
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
	private TokenDAO tokenDAO;
	@Autowired
	private MovieCentralUtil movieCentralUtil;
	
	@Autowired
	private MovieCentralMailingUtil movieCentralMailingUtil;
	
	
	public User signinUserService(User user) throws MovieCentralRepositoryException, MovieCentralValidationException {
		
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
		user.setEnable(false);
		
		
		userDao.signinUserDao(user);
		
		return user;
	}
	
	public void createVerificationTokenService(User user, String token) throws MovieCentralRepositoryException {
		VerificationToken newUserToken = new VerificationToken(token, user);
		tokenDAO.createVerificationTokenDao(newUserToken);
	}
	
	public VerificationToken getVerificationToken(String verificationToken) {
		return tokenDAO.findByToken(verificationToken);
	}
	
	public void enableRegisteredUser(User user) {
		userDao.save(user);
	}
}
