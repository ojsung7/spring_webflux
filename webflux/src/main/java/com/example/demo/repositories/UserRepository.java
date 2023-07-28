package com.example.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Long>{

}
