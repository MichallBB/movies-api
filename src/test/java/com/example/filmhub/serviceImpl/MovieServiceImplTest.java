package com.example.filmhub.serviceImpl;

import com.example.filmhub.model.Movie;
import com.example.filmhub.serviceImpl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.filmhub.model.Actor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceImplTest {

    @Autowired
    private MovieServiceImpl movieService;

    @Test
    void getMovieById() {
        Actor actor = Actor.builder()
                .name("Jason Derule")
                .realFullName("Will senior Smith jr.")
                .build();
        Movie movie = Movie.builder()
                .movieName("Oppenhaimer")
                .description("Opowiesc o twurcy bomby")
                .prodYear(2015)
                .actors(new ArrayList<>(Arrays.asList(actor, actor, actor, actor, actor, actor, actor)))
                .build();

        movieService.createMovie(movie);
        System.out.println(movie);
    }
}