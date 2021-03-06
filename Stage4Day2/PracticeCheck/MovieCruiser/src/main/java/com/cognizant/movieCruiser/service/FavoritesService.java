package com.cognizant.movieCruiser.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieCruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.movieCruiser.model.Movie;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesDaoCollectionImpl favoritesDaoCollectionImpl;
	
	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		
		return favoritesDaoCollectionImpl.getAllFavoritesMovies(userId);
	}
	
	public void removeFavoritesMovie(String userId, int movieId) {
		
		favoritesDaoCollectionImpl.removeFavoritesMovie(userId, movieId);
	}
	
	public void addFavoritesMovie(String userId, int movieId) {
		favoritesDaoCollectionImpl.addFavoritesMovie(userId, movieId);
	}
}
