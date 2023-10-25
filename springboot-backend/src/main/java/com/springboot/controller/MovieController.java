package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.MovieNotFoundException;
import com.springboot.model.Movie;
import com.springboot.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	// get all movies api
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	// get movie by title rest api
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new MovieNotFoundException("Movie does not exist with id :" + id));
		return ResponseEntity.ok(movie);
	}
	
}
