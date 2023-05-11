package com.projectstreamer.moviesservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Long rating;

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

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_and_starring",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "starring_id",referencedColumnName = "id"))
    private Set<Starring> starring;

}
