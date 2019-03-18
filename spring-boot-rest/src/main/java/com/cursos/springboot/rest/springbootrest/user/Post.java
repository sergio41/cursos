package com.cursos.springboot.rest.springbootrest.user;

import java.util.Date;

public class Post {
	private Integer id;
	private String message;
	private Date publicationDate;
	
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
}
