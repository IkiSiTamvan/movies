package com.tamvan.movie.movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies(Integer page, Integer size);
    Optional<Movie> getMovieById(Integer id);
    Movie save(Movie movie);
    void deleteById(Integer id);
}
