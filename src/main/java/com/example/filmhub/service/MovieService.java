package com.example.filmhub.service;

import com.example.filmhub.model.Movie;
import com.example.filmhub.model.MovieRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<Movie> getMovieById(Long id);
    List<Movie> getAllMovies();
    Movie createMovie(Movie movie);
    int deleteMovieById(Long id);
    Movie updateActorForMovie(Long movie_id, Long actor_id);
    String addMovieImage(MultipartFile file, Long file_id) throws IOException;

    List<Movie> findMoviesByMultipleActors(List<Long> actorId);
}
