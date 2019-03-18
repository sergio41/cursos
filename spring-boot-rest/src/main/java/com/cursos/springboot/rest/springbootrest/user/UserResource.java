package com.cursos.springboot.rest.springbootrest.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id){
		User findOne = service.findOne(id);
		if(findOne == null)
			throw new UserNotFoundException("id-"+id);
		Resource<User> resource = new Resource<User>(findOne);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User findOne = service.deleteById(id);
		if(findOne == null)
			throw new UserNotFoundException("id-"+id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id){
		return service.findAllPostForUser(id);
	}
	
	@GetMapping("/users/{id}/posts/{idPost}")
	public Post retrieveUser(@PathVariable int id, @PathVariable int idPost){
		Post findOne = service.findOnePostForUser(id, idPost);
		if(findOne == null)
			throw new UserNotFoundException("id-"+id + " idPost-" + idPost);
		return findOne;
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post){
		Post savedPost = service.savePost(id, post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{idPost}")
				.buildAndExpand(savedPost.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
