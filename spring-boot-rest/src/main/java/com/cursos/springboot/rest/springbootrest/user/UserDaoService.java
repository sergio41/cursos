package com.cursos.springboot.rest.springbootrest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		List<Post> post1 = new ArrayList<>();
		post1.add(new Post(1, "hola Holita", new Date()));
		post1.add(new Post(2, "QUE TAL?!", new Date()));


		List<Post> post2 = new ArrayList<>();
		post2.add(new Post(1, "hola Amigo", new Date()));
		post2.add(new Post(2, "BIEEEEEN", new Date()));


		List<Post> post3 = new ArrayList<>();
		post3.add(new Post(1, "Pus yo mal", new Date()));
		post3.add(new Post(2, "Jopetas", new Date()));

		users.add(new User(1, "Adam", new Date(), post1));
		users.add(new User(2, "Eve", new Date(), post2));
		users.add(new User(3, "Jack", new Date(), post3));
	}

	public List<User> findAll(){
		return users;
	}

	public User save(User user) {
		if(user.getId() == null)
			user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

	public Post findOnePostForUser(int id, int idPost) {
		for(User user:users) {
			if(user.getId() == id) {
				for(Post post:user.getPosts()) {
					if(post.getId() == idPost)
						return post;
				}
			}
		}
		return null;
	}

	public List<Post> findAllPostForUser(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user.getPosts();
			}
		}
		return null;
	}

	public Post savePost(int id, Post post) {
		for(User user:users) {
			if(user.getId() == id) {
				if(post.getId() == null)
					post.setId(user.getPosts().size()+1);
				user.getPosts().add(post);
			}
		}
		return post;
	}
}
