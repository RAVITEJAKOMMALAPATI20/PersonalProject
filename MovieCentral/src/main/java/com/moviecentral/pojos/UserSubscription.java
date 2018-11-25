/**
 * 
 */
package com.moviecentral.pojos;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
public class UserSubscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4518079043440671840L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="subscriptionid")
	private long subscriptionid;
	
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
	
	@Column(name="dropsubscription")
	private boolean dropsubscription;
	
	@Column(name="totalcost")
	private String totalcost;
	
	public String getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}
	@Column(name="payment")
	private String payment;
	

	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Id
	@Column(name="username")
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isAutoreneval() {
		return autoreneval;
	}
	public void setAutoreneval(boolean autoreneval) {
		this.autoreneval = autoreneval;
	}
	public long getSubscriptionid() {
		return subscriptionid;
	}
	public void setSubscriptionid(long subscriptionid) {
		this.subscriptionid = subscriptionid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		
		this.startdate = new java.util.Date();
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
	public boolean isDropsubscription() {
		return dropsubscription;
	}
	public void setDropsubscription(boolean dropsubscription) {
		this.dropsubscription = dropsubscription;
	}
}
