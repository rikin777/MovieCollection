package com.springboot.repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.model.Movie;

@Repository
public class MovieRepository implements IMovieRepository{
	
	public List<Movie> getAllMovies(){
		ObjectMapper mapper = new ObjectMapper();
		List<Movie> listMovies = new ArrayList<>();
		try {
			listMovies = mapper.readValue(MovieRepository.class.getResourceAsStream("/movies.json"), new TypeReference<ArrayList<Movie>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMovies;
	}
	
	public List<Movie> findByCriteria(String searchCriteria){
		List<Movie> listMovies = getAllMovies();
		
		//Filter conditions for additional criteria's can be done
		List<Movie> searchedMovies = listMovies.stream()
				.filter(movie -> StringUtils.containsIgnoreCase(movie.getTitle(), searchCriteria) 
						|| StringUtils.containsIgnoreCase(movie.getType(), searchCriteria)
							|| StringUtils.containsIgnoreCase(String.valueOf(movie.getYear()), searchCriteria))
				.collect(Collectors.toList());
		return searchedMovies;
	}

}