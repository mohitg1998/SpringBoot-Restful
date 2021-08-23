package com.rest.webservices.restfulwebservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.dao.PostRepository;
import com.rest.webservices.restfulwebservices.dao.UserRepository;
import com.rest.webservices.restfulwebservices.entities.Post;
import com.rest.webservices.restfulwebservices.entities.User;


@RestController
public class UserRestcontroller {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {	
		return userRepository.getById(id);
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		 userRepository.deleteById(id);
	} 
	
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id){
		 Optional<User> userOptional = userRepository.findById(id);
		 return userOptional.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public Post createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.get();
		post.setUser(user);
		return postRepository.save(post);
	}
	
	
}
