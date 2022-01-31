package com.boots.model;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String user;

	private String eng;

	private String rus;

	private String description;
	
	public Word() {
		super();
	}

	public Word(String user, String eng, String rus, String description, boolean isDone) {
		super();
		this.user = user;
		this.eng = eng;
		this.rus = rus;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) { this.user = user; }

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getRus() {
		return rus;
	}

	public void setRus(String rus) {
		this.rus = rus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}