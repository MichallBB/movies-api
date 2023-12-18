package com.example.filmhub.serviceImpl;

import com.example.filmhub.model.Actor;
import com.example.filmhub.model.Movie;
import com.example.filmhub.repository.ActorRepository;
import com.example.filmhub.repository.MovieRepository;
import com.example.filmhub.repository.MovieRoleRepository;
import com.example.filmhub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    private static final String UPLOAD_DIRECTORY = "E:\\springjpa\\angular\\filmhub\\src\\assets\\images\\movies\\";
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieRoleRepository movieRoleRepository,
                            ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }
    @Override
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }
    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }
    @Override
    public int deleteMovieById(Long id){
        if(movieRepository.findById(id).isEmpty()){
            return 0;
        }
        movieRepository.deleteById(id);
        if(movieRepository.findById(id).isPresent()){
            return 0;
        }
        return 1;
    }
    @Override
    public Movie updateActorForMovie(Long movie_id, Long actor_id) {
        Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new IllegalStateException("Movie not found"));
        Actor actor = actorRepository.findById(actor_id).orElseThrow(() -> new IllegalStateException("Can not find actor"));

        List<Actor> actors = (List<Actor>) movie.getActors();
        actors.add(actor);
        movie.setActors(actors);

        return movieRepository.save(movie);
    }
    @Override
    public String addMovieImage(MultipartFile file, Long file_id) throws IOException {
        Movie movie = movieRepository.findById(file_id).orElseThrow(() -> new IllegalStateException("Can not find movie"));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, String.valueOf(file_id) + ".jpg");
        Files.write(fileNameAndPath, file.getBytes());
        String fullPath = UPLOAD_DIRECTORY + file_id;
        movie.setMovieImageFileId(fullPath);
        movieRepository.save(movie);
        return "Image added successfully";
    }

    public List<Movie> findMoviesByMultipleActors(List<Long> actorId) {

        List<Movie> movies = movieRepository.findAll();
        List<Movie> result = new ArrayList<Movie>();
        System.out.println(actorId);
        for(Movie movie : movies) {
            // 1: true
            // 2: false
            // hashmap to store actors id and true or fals if it is in movie
            if (movie.getActors().isEmpty()) {
                break;
            }
            Map<Long, Boolean> map = new HashMap<Long, Boolean>();

            for(Actor actor : movie.getActors()) {
                map.put(actor.getId(), false);
                for(Long id : actorId){
                    if(actor.getId().equals(id)){
                        map.put(id, true);
                    }
                }
            }

            // check if all hashmap rows is true then add movie to result
            boolean allTrue = true;
            for (boolean value : map.values()) {
                if (!value) {
                    allTrue = false;
                    break;
                }
            }
            if (allTrue) {
                result.add(movie);
            }
        }
        return result;
    }
}
