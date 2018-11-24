/**
 * 
 */
package com.moviecentral.utils;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ravitejakommalapati
 *
 */
@Component
public class MovieCentralUtil {
	private static final int EXPIRATION = 60 * 24;
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
		
		public boolean decodePassword(String inpassword,String dbpassword) {
			return passwordEncoder.matches(inpassword, dbpassword); 
		}
		public String encodePassword(String password) {
			return passwordEncoder.encode(password);
		}
		
		public String getJSONFromObject(Object obj ) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString =null;
			
			try {
				jsonInString = mapper.writeValueAsString(obj);
			} catch (JsonProcessingException e) {
				return "Error in Converting to JSON String";
			}
			return jsonInString;
		}
		
		
		public Date calculateExpiryDate() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Timestamp(calendar.getTime().getTime()));
			calendar.add(Calendar.MINUTE, EXPIRATION);
			return new Date(calendar.getTime().getTime());
			}
		
		
		public Date calculateSupsriptionEnddate(int duration) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.MONTH, duration);
			return new Date(calendar.getTime().getTime());
		}
		
}
