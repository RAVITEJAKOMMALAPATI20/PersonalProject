/**
 * 
 */
package com.moviecentral.pojos;

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

/**
 * @author ravitejakommalapati
 *
 */

@Entity
@Table(name="payment")
@NamedQueries({
	@NamedQuery(
	name = "Payment.getAllpaymentdetails",
	query = "select P from Payment P where P.username = :username"
	)
})
public class Payment {

@Id
@Column(name="id")
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column(name="cardnumber")
private String cardnumber;
@Column(name="cvv")
private String cvv;
@Column(name="cardholder")
private String cardholder;
@Column(name="expirymonth")
private int expirymonth;
@Column(name="expiryyear")
private int expiryyear;
@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
@JoinColumn(name = "username", nullable = false)
private User user;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCardnumber() {
	return cardnumber;
}
public void setCardnumber(String cardnumber) {
	this.cardnumber = cardnumber;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getCardholder() {
	return cardholder;
}
public void setCardholder(String cardholder) {
	this.cardholder = cardholder;
}
public int getExpirymonth() {
	return expirymonth;
}
public void setExpirymonth(int expirymonth) {
	this.expirymonth = expirymonth;
}
public int getExpiryyear() {
	return expiryyear;
}
public void setExpiryyear(int expiryyear) {
	this.expiryyear = expiryyear;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
