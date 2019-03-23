package com.cursos.springboot.rest.springbootrest.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String message;
	private Date publicationDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Post() {
		super();
	}
	
	public Post(Integer id, String message, Date publicationDate) {
		super();
		this.id = id;
		this.message = message;
		this.publicationDate = publicationDate;
	}

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}
