package com.streamer.authservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "roles_authorities",
                joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name="authority_id",referencedColumnName = "id"))
    private Set<Authority> authorities;
}
