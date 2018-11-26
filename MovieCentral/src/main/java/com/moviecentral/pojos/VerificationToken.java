/**
 * 
 */
package com.moviecentral.pojos;

import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * @author ravitejakommalapati
 *
 */


@Entity
@Table(name = "verification_token")

@NamedQueries({
	@NamedQuery(
	name = "VerificationToken.findByToken",
	query = "select s from VerificationToken s where s.token = :token"
	)
})
public class VerificationToken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int EXPIRATION = 60 * 24;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="token")
	private String token;

	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private User user;
	public VerificationToken() {
		super();
	}

	public VerificationToken(final String token) {
		super();

		this.token = token;
		this.expiryDate = this.calculateExpiryDate();
	}

	public VerificationToken(final String token, final User user) {
		super();
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		this.token = token;
		this.user = user;
		this.createdDate = new java.util.Date(currentDate.getTime());
		this.expiryDate = this.calculateExpiryDate();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(java.sql.Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	private Date calculateExpiryDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Timestamp(calendar.getTime().getTime()));
		calendar.add(Calendar.MINUTE, EXPIRATION);
		return new Date(calendar.getTime().getTime());
		}

}