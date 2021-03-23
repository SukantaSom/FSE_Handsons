package com.cognizant.moviecruiser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@SpringBootApplication
public class MovieCruiserApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	private static MovieService movieService;

	public static void main(String[] args) {
		LOGGER.info("Inside main()");

		ApplicationContext context = SpringApplication.run(MovieCruiserApplication.class, args);

		movieService = context.getBean(MovieService.class);
		
		// MCUC001
				 testGetMovieListAdmin();
		// MCUC002
				// testGetMovie();
				 testModifyMovie();
		// MCUC003
				 testGetMovieListCustomer();
		
		
	}

	public static void testGetMovieListAdmin() {
		LOGGER.info("Start : testGetMovieListAdmin()");

		List<Movie> movieList = movieService.getMovieListAdmin();

		LOGGER.debug("Movies :{}", movieList);

		LOGGER.info("End : testGetMovieListAdmin()");
	}

	public static void testGetMovieListCustomer() {
		LOGGER.info("Start : testGetMovieListCustomer()");

		List<Movie> movieList = movieService.getMovieListCustomer();

		LOGGER.debug("Movies :{}", movieList);

		LOGGER.info("End : testGetMovieListCustomer()");
	}

	public static void testGetMovie() {
		LOGGER.info("Start : testGetMovie()");

		Movie movie = movieService.getMovie(1);

		LOGGER.debug("Movies :{}", movie);

		LOGGER.info("End : testGetMovie()");
	}

	public static void testModifyMovie() {
		LOGGER.info("Start : testModifyMovie()");

		Movie movie = movieService.getMovie(1);
		movie.setBoxOffice("$2,78,79,65,087");
		movieService.modifyMovie(movie);
		LOGGER.debug("Movies :{}", movie);

		LOGGER.info("End : testModifyMovie()");
	}

}
