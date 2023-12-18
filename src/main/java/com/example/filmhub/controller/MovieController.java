package com.example.filmhub.controller;

import com.example.filmhub.model.Actor;
import com.example.filmhub.model.Movie;
import com.example.filmhub.serviceImpl.ActorServiceImpl;
import com.example.filmhub.serviceImpl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private final MovieServiceImpl movieService;
    @Autowired
    private MovieController(MovieServiceImpl movieService){
        this.movieService = movieService;
    }

    @GetMapping()
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
        return ResponseEntity.ok().body(1);
    }

    @PatchMapping("/{movie_id}/{actor_id}")
    public Movie updateActorsForMovie(@PathVariable Long movie_id, @PathVariable Long actor_id){
        return movieService.updateActorForMovie(movie_id, actor_id);
    }

    @PatchMapping("/image/{id}")
    public ResponseEntity<String> addFileImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        String result = movieService.addMovieImage(file, id);
        return ResponseEntity.ok().body(result);
    }
    // parameter variables names can be randomly chosen but have to be unique
    // method searches for a movie by multiple actors id given in parameters
    @GetMapping("/actors")
    public ResponseEntity<List<Movie>> getMoviesByActors(@RequestParam Map<String, String> actor_id){
        // map to list of actors ids
        List<Long> actors_id = new ArrayList<Long>();
        for (String actors_ids : actor_id.values()){
            actors_id.add(Long.parseLong(actors_ids));
        }

        List<Movie> result = movieService.findMoviesByMultipleActors(actors_id);
        return ResponseEntity.ok().body(result);
    }
}
