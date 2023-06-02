package com.projectstreamer.moviesservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String thumbnailUrl;

    @Column(nullable = false)
    private String releasedYear;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Float rating;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_and_genre",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id",referencedColumnName = "id"))
    private Set<Genre> genre;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_and_languages",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "language_id",referencedColumnName = "id"))
    private Set<Language> languages;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "movie")
    private Set<Role> cast;

}
