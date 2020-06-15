package com.cognizant.movieCruiser.dao;

import java.util.ArrayList;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.movieCruiser.MovieCruiserApplication;
import com.cognizant.movieCruiser.exception.FavoritesEmptyException;
import com.cognizant.movieCruiser.model.Favorites;
import com.cognizant.movieCruiser.model.Movie;

@Service
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	@Autowired
	private MovieDaoCollectionImpl moiveDaoCollectionImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	private static HashMap<String, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if(userFavorites==null)
		{
			userFavorites = new HashMap<String,Favorites>();
		}
	}

	@Override
	public void addFavoritesMovie(String userId, int movieId) {

		LOGGER.info("CartDaoImpl addFavoritesMovie() START");
		Movie movie = moiveDaoCollectionImpl.findById(movieId);

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			movieFavoritesList.add(movie);
		} else {
			Favorites favorite = new Favorites(new ArrayList<Movie>(), userId);
			favorite.getFavoritesMovieList().add(movie);
			userFavorites.put(userId, favorite);
		}
		LOGGER.debug("UserId:{}", userId);
		LOGGER.debug("MovieId: {}", movieId);
		LOGGER.debug("UserFavorites:{}", userFavorites);

		LOGGER.info("CartDaoImpl addFavoritesMovie() END");

	}

	@Override
	public ArrayList<Movie> getAllFavoritesMovies(String userId) {
		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getAllFavoritesMovies(String userId) START");

		if (userFavorites.containsKey(userId)) {
			double total = 0.0;
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();
			if (movieFavoritesList.isEmpty()) {
				throw new FavoritesEmptyException();
			}

			LOGGER.debug("UserMovieList: {}", movieFavoritesList);
			LOGGER.debug("UserId: {}", userId);
			return movieFavoritesList;
		}

		LOGGER.info("MovieDaoCollectionImpl ArrayList<Movie> getAllFavoritesMovies(String userId) END");
		throw new FavoritesEmptyException();
	}

	@Override
	public void removeFavoritesMovie(String userId, int movieId) {
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie(int userId, int movieId) START");
		Movie movie = moiveDaoCollectionImpl.findById(movieId);

		if (userFavorites.containsKey(userId)) {
			ArrayList<Movie> movieFavoritesList = userFavorites.get(userId).getFavoritesMovieList();

			for (int i = 0; i < movieFavoritesList.size(); i++) {
				if (movieFavoritesList.get(i).getId() == movieId) {
					movieFavoritesList.remove(i);
				}
			}
			LOGGER.debug("userId: {}", userId);
			LOGGER.debug("movieId: {}", movieId);
			LOGGER.debug("MovieFavoritesList: {}", movieFavoritesList);
			LOGGER.debug("UserFavorites: {}", userFavorites);
		} else {
			throw new FavoritesEmptyException();
		}

		LOGGER.debug("UserId: {}", userId);
		LOGGER.debug("MovieId: {}", movieId);

		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie(int userId, int movieId) END");

	}

}
