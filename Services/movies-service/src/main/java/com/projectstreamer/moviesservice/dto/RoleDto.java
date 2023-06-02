package com.projectstreamer.moviesservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto {
    private Long id;
    private String role;
    private ActorDto actor;
    private Long movie;
}
