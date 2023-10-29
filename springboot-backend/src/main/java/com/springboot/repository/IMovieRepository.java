package com.springboot.repository;

import java.util.List;

import com.springboot.model.Movie;

public interface IMovieRepository {
	
	public List<Movie> getAllMovies();
	
	public List<Movie> findByCriteria(String searchCriteria);

}
