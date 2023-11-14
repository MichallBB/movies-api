package com.example.filmhub.serviceImpl;

import com.example.filmhub.model.Actor;
import com.example.filmhub.repository.ActorRepository;
import com.example.filmhub.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @Override
    public Optional<Actor> getActorById(Long id){
        return actorRepository.findById(id);
    }
    @Override
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    @Override
    public Actor createActor(Actor actor){
        return actorRepository.save(actor);
    }
}
