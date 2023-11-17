package com.example.filmhub.serviceImpl;

import com.example.filmhub.DTO.MovieRoleDTO;
import com.example.filmhub.model.Actor;
import com.example.filmhub.model.Movie;
import com.example.filmhub.model.MovieRole;
import com.example.filmhub.repository.ActorRepository;
import com.example.filmhub.repository.MovieRepository;
import com.example.filmhub.repository.MovieRoleRepository;
import com.example.filmhub.service.MovieRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieRoleServiceImpl implements MovieRoleService {
    private final MovieRoleRepository movieRoleRepository;
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    @Autowired
    public MovieRoleServiceImpl(MovieRoleRepository movieRoleRepository,
                                MovieRepository movieRepository,
                                ActorRepository actorRepository) {
        this.movieRoleRepository = movieRoleRepository;
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }
    @Override
    public Optional<MovieRole> getMovieRoleById(Long id){
        return movieRoleRepository.findById(id);
    }
    @Override
    public List<MovieRole> getAllMovieRoles(){
        return movieRoleRepository.findAll();
    }

    @Override
    public MovieRole createMovieRole(Long movie_id, Long actor_id, MovieRoleDTO movieName){
        Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new IllegalStateException("Movie not found"));
        Actor actor = actorRepository.findById(actor_id).orElseThrow(() -> new IllegalStateException("Can not find actor"));
        MovieRole movieRole = new MovieRole();
        movieRole.setMovie(movie);
        movieRole.setActor(actor);
        movieRole.setRoleName(movieName.getRoleName());
        return movieRoleRepository.save(movieRole);
    }
    @Override
    public int deleteMovieRoleById(Long id){
        movieRoleRepository.deleteById(id);
        if(movieRoleRepository.findById(id).isPresent()){
            return 0;
        }
        return 1;
    }

    public MovieRole getMovieRoleByActorId(Long id) {
        try{
            return movieRoleRepository.findByActorId(id);
        }catch (IllegalStateException e){
            throw e;
        }
    }
}
