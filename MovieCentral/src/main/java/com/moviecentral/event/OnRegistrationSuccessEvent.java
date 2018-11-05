/**
 * 
 */
package com.moviecentral.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.moviecentral.pojos.User;

/**
 * @author ravitejakommalapati
 *
 */

public class OnRegistrationSuccessEvent extends ApplicationEvent {

/**
	 * 
	 */
	private static final long serialVersionUID = 4907121990650752372L;
private String appUrl;
private User user;
private Locale locale;
public Locale getLocale() {
	return locale;
}
public void setLocale(Locale locale) {
	this.locale = locale;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public OnRegistrationSuccessEvent(User user,Locale locale, String appUrl) {
super(user);
this.user = user;
this.appUrl = appUrl;
this.locale =locale;
}
public String getAppUrl() {
return appUrl;
}
public void setAppUrl(String appUrl) {
this.appUrl = appUrl;
}
public User getUser() {
return user;
}
public void setUser(User user) {
this.user = user;
}
}