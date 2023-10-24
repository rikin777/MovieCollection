package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.exception.GlobalExceptionHandler;
import com.java.model.Movie;
import com.java.repository.MovieRepository;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	// get all movies est api
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	// get movie by name rest api
	@GetMapping("/movies/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
		Movie movie = movieRepository.findByName(name)
				.orElseThrow(() -> new MovieNotFoundException("Movie not exist with name :" + name));
		return ResponseEntity.ok(movie);
	}
	
}
