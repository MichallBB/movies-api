package com.example.filmhub.controller;

import com.example.filmhub.DTO.MovieRoleDTO;
import com.example.filmhub.model.Movie;
import com.example.filmhub.model.MovieRole;
import com.example.filmhub.repository.MovieRepository;
import com.example.filmhub.serviceImpl.MovieRoleServiceImpl;
import com.example.filmhub.serviceImpl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/movieroles")
public class MovieRoleController {
    private final MovieRoleServiceImpl movieRoleService;
    private final MovieRepository movieRepository;

    @Autowired
    private MovieRoleController(MovieRoleServiceImpl movieRoleService,
                                MovieRepository movieRepository){
        this.movieRoleService = movieRoleService;
        this.movieRepository = movieRepository;
    }

    @GetMapping()
    public List<MovieRole> getAllMovieRoles(){
        return movieRoleService.getAllMovieRoles();
    }

    @GetMapping("/{id}")
    public Optional<MovieRole> getMovieRoleById(@PathVariable Long id){
        return movieRoleService.getMovieRoleById(id);
    }

    @PostMapping("/{movie_id}/{actor_id}")
    public MovieRole createMovieRole(@PathVariable Long movie_id,@PathVariable Long actor_id, @RequestBody MovieRoleDTO movieName){
        return movieRoleService.createMovieRole(movie_id, actor_id, movieName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteMovieRoleById(@PathVariable Long id){
        movieRoleService.deleteMovieRoleById(id);
        return ResponseEntity.ok().body(1);
    }
    @GetMapping("/actor/{id}")
    public MovieRole getMovieRoleByActorId(@PathVariable Long id){
        return movieRoleService.getMovieRoleByActorId(id);
    }
}
