package com.cognizant.movieCruiser.dao;

import java.util.ArrayList;

import com.cognizant.movieCruiser.model.Movie;

public interface MovieDao {

	public ArrayList<Movie> getMovieListAdmin();
	public ArrayList<Movie> getMovieListCustomer();
	public Movie findById(int id);
	public void modifyMovie(Movie movie);
	public ArrayList<Movie> getMovieListActive();

}
