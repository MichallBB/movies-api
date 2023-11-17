package com.example.filmhub.repository;

import com.example.filmhub.model.Actor;
import com.example.filmhub.model.Movie;
import com.example.filmhub.serviceImpl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;
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
    }
}