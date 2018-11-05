/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.moviecentral.utils.JpaConverterJson;

/**
 * @author ravitejakommalapati
 *
 */

@Entity
@Table(name="users")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5951671449717112013L;
	
	
	@Id
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Id
	@Column(name="email")
	private String email;
	@Column(name="usertype")
	private boolean userType;
	@Column(name="details")
	@Convert(converter = JpaConverterJson.class)
	private UserDetails details;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isUserType() {
		return userType;
	}
	public void setUserType(boolean userType) {
		this.userType = userType;
	}
	public UserDetails getDetails() {
		return details;
	}
	public void setDetails(UserDetails details) {
		this.details = details;
	}
	

}
