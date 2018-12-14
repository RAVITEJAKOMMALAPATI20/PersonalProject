/**
 * 
 */
package com.moviecentral.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ravitejakommalapati
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(
	name = "PayPerview.checkUser",
	query = "select U from PayPerview U where U.user = :user AND U.movie = :movie"
	),
	@NamedQuery(
			name = "PayPerview.usermovies",
			query = "select U from PayPerview U where U.user = :user"
			)
})
public class PayPerview  implements Serializable{
	

	@Id
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@Id
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User user;
	
	@Column(name="paymentdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentdate;
	
	@Column(name="cost")
	private String cost;
	
	@Column(name="payment")
	private String payment;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	

}
