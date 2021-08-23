package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservices.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
