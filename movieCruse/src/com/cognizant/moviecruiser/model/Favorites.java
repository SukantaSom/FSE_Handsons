package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {
	private List<Movie> movieList;
	private long noOfFavorites;

	public Favorites(List<Movie> movieList, long noOfFavorites) {
		super();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(long noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}

}
