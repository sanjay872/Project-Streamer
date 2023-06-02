package com.projectstreamer.moviesservice.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String about;
    private String imageUrl;
}
