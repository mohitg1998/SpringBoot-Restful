package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.webservices.restfulwebservices.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
