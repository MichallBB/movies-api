package com.example.filmhub.repository;

import com.example.filmhub.model.MovieRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRoleRepository extends JpaRepository<MovieRole, Long> {
    @Query("SELECT mr FROM MovieRole mr WHERE mr.actor.id = :actorId")
    MovieRole findByActorId(@Param("actorId") Long actorId);
}