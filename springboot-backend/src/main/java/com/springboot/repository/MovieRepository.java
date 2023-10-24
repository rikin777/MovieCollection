package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}