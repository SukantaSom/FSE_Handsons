package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
		}
	}

	@Override
	public void addFavoritesMovie(long userId, long movieId) {
		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);

		if (userFavorites.containsKey(userId)) {
			List<Movie> movieList = userFavorites.get(userId).getMovieList();
			movieList.add(movie);
		} else {
			Favorites favorites = new Favorites(new ArrayList<Movie>(), 0);
			favorites.getMovieList().add(movie);
			userFavorites.put(userId, favorites);
		}
	}

	@Override
	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException {
		if (userFavorites.containsKey(userId)) {
			List<Movie> movieList = userFavorites.get(userId).getMovieList();
			if (movieList.isEmpty()) {
				throw (new FavoritesEmptyException());
			} else {
				userFavorites.get(userId).setNoOfFavorites(movieList.size());
			}
			return movieList;
		} else {
			throw (new FavoritesEmptyException());
		}
	}

	@Override
	public void removeFavoritesMovie(long userId, long movieId) {
		List<Movie> movieList = userFavorites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
				break;
			}
		}
	}

}
