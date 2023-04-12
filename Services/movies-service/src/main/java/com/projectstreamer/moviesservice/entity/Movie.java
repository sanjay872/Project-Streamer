package com.projectstreamer.moviesservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String thumbnailUrl;

    @Column(nullable = false)
    private Date releasedDate;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Set<Genre> genre;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Set<Language> languages;

    @OneToOne(fetch = FetchType.EAGER,cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.EAGER, cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movie_and_starring",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "starring_id",referencedColumnName = "id"))
    private Set<Starring> starring;

}
