package com.example.filmhub.serviceImpl;

import com.example.filmhub.model.Actor;
import com.example.filmhub.repository.ActorRepository;
import com.example.filmhub.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
    private static final String UPLOAD_DIRECTORY = "E:\\springjpa\\angular\\filmhub\\src\\assets\\images\\actors\\";
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
    @Override
    public int deleteActorById(Long id){
        actorRepository.deleteById(id);
        if(actorRepository.findById(id).isPresent()){
            return 0;
        }
        return 1;
    }

    @Override
    public String addActorImage(MultipartFile file, Long file_id) throws IOException {
        Actor actor = actorRepository.findById(file_id).orElseThrow(() -> new IllegalStateException("Can not find actor"));
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, String.valueOf(file_id) + ".jpg");
        Files.write(fileNameAndPath, file.getBytes());
        String fullPath = UPLOAD_DIRECTORY + file_id;
        actor.setImageFileId(fullPath);
        actorRepository.save(actor);
        return "test";
    }
}
