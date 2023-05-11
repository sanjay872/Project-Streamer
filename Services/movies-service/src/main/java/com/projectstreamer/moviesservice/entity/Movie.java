package com.projectstreamer.moviesservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<SubMasterData> genre;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<SubMasterData> languages;

    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.EAGER, cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movie_and_starring",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "starring_id",referencedColumnName = "id"))
    private List<Starring> starring;

}
