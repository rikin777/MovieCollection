package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Movie;
import com.springboot.repository.IMovieRepository;

@Service
public class MovieService implements IMovieService{
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.getAllMovies();
	}
	
	public List<Movie> findByCriteria(String searchCriteria){
		return movieRepository.findByCriteria(searchCriteria);
	}

}
