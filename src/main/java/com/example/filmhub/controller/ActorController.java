package com.example.filmhub.controller;

import com.example.filmhub.model.Actor;
import com.example.filmhub.serviceImpl.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ActorController {

    private final ActorServiceImpl actorService;
    @Autowired
    private ActorController(ActorServiceImpl actorService){
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/actors/{id}")
    public Optional<Actor> getActorById(@RequestParam Long id){
        return actorService.getActorById(id);
    }

    @PostMapping("/actors")
    public Actor createActor(@RequestBody Actor actor){
        return actorService.createActor(actor);
    }

}
