/**
 * 
 */
package com.moviecentral.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author ravitejakommalapati
 *
 */

@Entity
@Table(name="usersubscriptions")

@NamedQueries({
	@NamedQuery(
	name = "UserSubscription.getAllsubscriptions",
	query = "select US from UserSubscription US where US.username = :username"
	)
})
public class UserSubscription {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="subscriptionid")
	private String subscriptionid;
	
	@Column(name="startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	
	@Column(name="enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="subscriptionstatus")
	private boolean subscriptionstatus;
	
	@Column(name="autoreneval")
	private boolean autoreneval;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private User user;
	
	
	
	
	public boolean isAutoreneval() {
		return autoreneval;
	}
	public void setAutoreneval(boolean autoreneval) {
		this.autoreneval = autoreneval;
	}
	public String getSubscriptionid() {
		return subscriptionid;
	}
	public void setSubscriptionid(String subscriptionid) {
		this.subscriptionid = subscriptionid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isSubscriptionstatus() {
		return subscriptionstatus;
	}
	public void setSubscriptionstatus(boolean subscriptionstatus) {
		this.subscriptionstatus = subscriptionstatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
