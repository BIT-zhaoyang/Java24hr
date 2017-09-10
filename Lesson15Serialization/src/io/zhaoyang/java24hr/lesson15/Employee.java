package io.zhaoyang.java24hr.lesson15;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String lName;
	String fName;
	transient double salary;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("First Name: ");
		sb.append(fName);
		sb.append("\n");
		sb.append("Last Name: ");
		sb.append(lName);
		sb.append("\n");
		sb.append("Salary: ");
		sb.append(salary);
		sb.append("\n");
		
		return sb.toString();
	}
}
