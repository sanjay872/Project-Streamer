package com.projectstreamer.moviesservice.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private Long releasedYear;
    private String duration;
    private Float rating;
    private Set<GenreDto> genre;
    private Set<LanguageDto> languages;
    private Set<RoleDto> cast;
}
