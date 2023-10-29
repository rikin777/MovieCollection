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
import com.springboot.service.IMovieService;
import com.springboot.service.MovieService;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	// get all movies api
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	// get movie by title rest api
	@GetMapping("/movies/{searchCriteria}")
	public ResponseEntity<List<Movie>> getMovieByCriteria(@PathVariable String searchCriteria) {
		List<Movie> listMovies = movieService.findByCriteria(searchCriteria);
				//.orElseThrow(() -> new MovieNotFoundException("Movie does not exist with id :" + searchCriteria));
		return ResponseEntity.ok(listMovies);
	}
	
}
//Fetch all movies API call:
//http://localhost:8080/api/v1/movies

//Fetch movies by search criteria API call:
//http://localhost:8080/api/v1/movies/god
//Returns 2 results