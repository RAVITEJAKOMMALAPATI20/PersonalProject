package com.project.beans;

import com.project.interfaces.Greeter;
import com.project.utils.ProjectsConstants;

/**
 * @author ravitejakommalapati
 *
 */
public class Greet implements Greeter{
private String name;
	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getGreeting() {
		String response =ProjectsConstants.GREETINGMESSAGE+name+ProjectsConstants.EXCLAMATION_MARK;
		return response;
	}

}
