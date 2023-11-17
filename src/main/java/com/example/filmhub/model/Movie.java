package com.example.filmhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String movieName;
    private int prodYear;
    private String description;
    private List<String> directions;
    private List<String> scenarios;
    private List<String> movieGenre;
    private List<String> prodCountries;
    private String premiereDateAndPlace;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "Movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actors_id"))
    private Collection<Actor> actors = new ArrayList<>();

//    @OneToMany(mappedBy = "movie")
//    private List<MovieRole> roles;
}
