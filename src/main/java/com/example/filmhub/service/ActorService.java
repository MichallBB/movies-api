package com.example.filmhub.service;

import com.example.filmhub.model.Actor;

import java.util.List;
import java.util.Optional;


public interface ActorService {
    Optional<Actor> getActorById(Long id);
    List<Actor> getAllActors();
    Actor createActor(Actor actor);
}
