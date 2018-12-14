/**
 * 
 */
package com.moviecentral.services;

import java.util.List;

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
	
	
	public User signinUserService(User user)  {
		
		
		
		//Null Checks for important data
		if(user==null || user.getEmail() == null || user.getUsername() == null || user.getPassword() == null) {
			throw new MovieCentralValidationException("The data you entered is invalid");
		}
		
		//if(!movieCentralUtil.validateEmail(user.getEmail())){
		//	
		//	throw new MovieCentralValidationException("The data you entered is invalid");
		//}
		
		//Encoding the String password using BCryptPasswordEncoder
		String encodedpassword = movieCentralUtil.encodePassword(user.getPassword());
		user.setPassword(encodedpassword);
		user.setEnable(false);
		
		User resuser =userDao.signinUserDao(user);
		
		
		return resuser;
	}
	
public User loginUserService(User user)  {
		
		//Null Checks for important data
		if(user==null || user.getUsername() == null || user.getPassword() == null) {
			throw new MovieCentralValidationException("The data you entered is invalid");
		}
		User regestered = userDao.loginUserDao(user);
		
		//boolean encodedpassword = movieCentralUtil.decodePassword(user.getPassword(), regestered.getPassword());
		
		//if(!encodedpassword) {
			//return regestered;
		//}
		System.out.println("IS Enabled"+regestered.isEnable());
		/*if(regestered!=null && regestered.getUsername()!=null&&!regestered.isEnable()) {
			throw new MovieCentralValidationException("Please Confirm your Registration");
		}*/
		
		return regestered;
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
    
	
	public List<User> getAllUsersService() {
		
		
		
		return userDao.getAllUsersDao();
	}
    
	public User updateuserService(User user) {
		
		
		
		return userDao.updateuserDao(user);
	}
}
