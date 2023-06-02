package com.projectstreamer.moviesservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @ManyToOne()
    @JoinColumn(name = "actor",nullable = false, referencedColumnName = "id")
    private Actor actor;

    @ManyToOne()
    @JoinColumn(name = "movie",nullable = false,referencedColumnName = "id")
    private Movie movie;
}
