/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="enable")
	private boolean enable;
	@Column(name="usertype")
	private boolean usertype;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="middlename")
	private String middlename;
	@Column(name="phonenumber")
	private String phonenumber;
	

	
	@OneToOne(mappedBy = "user",cascade=CascadeType.ALL)
    private VerificationToken library;
	
	public VerificationToken getLibrary() {
		return library;
	}
	public void setLibrary(VerificationToken library) {
		this.library = library;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public boolean isUsertype() {
		return usertype;
	}
	public void setUsertype(boolean usertype) {
		this.usertype = usertype;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
	

}
