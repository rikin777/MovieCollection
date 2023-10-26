package com.springboot.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.model.Movie;

@Repository
public class MovieRepository{
	
	public List<Movie> getAllMovies(){
		return new ArrayList<Movie>();
	}

}