package com.example.filmhub.service;

import com.example.filmhub.model.Actor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface ActorService {
    Optional<Actor> getActorById(Long id);
    List<Actor> getAllActors();
    Actor createActor(Actor actor);
    int deleteActorById(Long id);
    String addActorImage(MultipartFile file, Long file_id) throws IOException;
}
