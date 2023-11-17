package com.example.filmhub.service;

import com.example.filmhub.DTO.MovieRoleDTO;
import com.example.filmhub.model.Actor;
import com.example.filmhub.model.MovieRole;

import java.util.List;
import java.util.Optional;

public interface MovieRoleService {
    Optional<MovieRole> getMovieRoleById(Long id);
    List<MovieRole> getAllMovieRoles();
    MovieRole createMovieRole(Long movie_id, Long actor_id, MovieRoleDTO movieName);
    int deleteMovieRoleById(Long id);
    MovieRole getMovieRoleByActorId(Long id);
}
