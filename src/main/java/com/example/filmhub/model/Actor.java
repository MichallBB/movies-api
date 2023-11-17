package com.example.filmhub.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "real_full_name")
    private String realFullName;
    private String imageFileId;
    @Lob
    private String description;
    private Integer age;
    private Date birthDate;
    private String birthPlace;
    private Integer height;
//    @OneToMany(mappedBy = "actor")
//    private List<MovieRole> roles;
}