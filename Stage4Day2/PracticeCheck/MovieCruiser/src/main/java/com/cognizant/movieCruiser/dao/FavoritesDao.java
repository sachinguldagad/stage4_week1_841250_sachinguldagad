package com.cognizant.movieCruiser.dao;

import java.util.ArrayList;

import com.cognizant.movieCruiser.exception.FavoritesEmptyException;
import com.cognizant.movieCruiser.model.Movie;

public interface FavoritesDao {

		public void addFavoritesMovie(String userId, int movieId);
		public ArrayList<Movie> getAllFavoritesMovies(String userId) throws FavoritesEmptyException;
		public void removeFavoritesMovie(String userId, int movieId);
}
