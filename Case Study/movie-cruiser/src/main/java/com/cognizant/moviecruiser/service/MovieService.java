package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService implements MovieDao {

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		
		return movieRepository.findAll();
	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> list = movieRepository.findByActiveAndDateOfLaunchBefore(true, new Date());
		return list;
	}

	@Transactional
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.save(movie);
	}

	@Transactional
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		Movie movie = movieRepository.findById(movieId).get();
		
		return movie;
	}

	
	
}
