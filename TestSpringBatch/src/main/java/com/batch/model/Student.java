package com.batch.model;

public class Student {
	
	private String name;
	
	private String mail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "student [name=" + name + ", mail=" + mail + "]";
	}

	public Student() {
		
	}
	
	
	

}
