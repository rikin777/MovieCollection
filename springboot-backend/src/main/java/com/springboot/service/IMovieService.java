package com.springboot.service;

import java.util.List;

import com.springboot.model.Movie;

public interface IMovieService {
	
	public List<Movie> getAllMovies();
	
	public List<Movie> findByCriteria(String searchCriteria);

}
