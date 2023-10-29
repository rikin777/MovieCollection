package com.springboot;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.model.Movie;
import com.springboot.service.IMovieService;

import org.junit.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootBackendApplicationTests {
	
	@Autowired
	private IMovieService movieService;

	@Before
	public void setup() {				
	}
	
	@Test
	void testAllMovies() {
		List<Movie> listMovies = movieService.getAllMovies();
		Assert.assertEquals(10, listMovies.size());
	}
	
	@Test
	void testSearchMovies() {
		List<Movie> listMovies = movieService.findByCriteria("god");
		Assert.assertEquals(2, listMovies.size());
	}

}
