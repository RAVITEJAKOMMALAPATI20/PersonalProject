/**
 * 
 */
package com.moviecentral.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author ravitejakommalapati
 *
 */
@Component
public class MovieCentralUtil {
	private Pattern pattern;
	private Matcher matcher;
	private  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		public MovieCentralUtil() {
			pattern = Pattern.compile(EMAIL_PATTERN);
		}

		/**
		 * Validate hex with regular expression
		 * 
		 * @param hex
		 *            hex for validation
		 * @return true valid hex, false invalid hex
		 */
		public boolean validateEmail(final String email) {

			matcher = pattern.matcher(email);
			return matcher.matches();

		}
		
		public String encodePassword(String password) {
			return passwordEncoder.encode(password);
		}

}
