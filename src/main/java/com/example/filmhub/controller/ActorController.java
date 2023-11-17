package com.example.filmhub.controller;

import com.example.filmhub.model.Actor;
import com.example.filmhub.serviceImpl.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Optional<Actor> getActorById(@PathVariable Long id){
        return actorService.getActorById(id);
    }

    @PostMapping("/actors")
    public Actor createActor(@RequestBody Actor actor){
        return actorService.createActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<Integer> deleteActorById(@PathVariable Long id){
        actorService.deleteActorById(id);
        return ResponseEntity.ok().body(1);
    }

    @PatchMapping("/actors/image/{id}")
    public ResponseEntity<String> addFileImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        String result = actorService.addActorImage(file, id);
        return ResponseEntity.ok().body(result);
    }
}
