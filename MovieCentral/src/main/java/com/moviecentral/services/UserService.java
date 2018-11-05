/**
 * 
 */
package com.moviecentral.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.moviecentral.dao.UserDAO;
import com.moviecentral.pojos.User;

/**
 * @author ravitejakommalapati
 *
 */
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	public void saveUserService(User user) {
		UserDAO userDao = new UserDAO();
		userDao.saveUserDao(user);
	}
}
