package com.projectstreamer.moviesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private String releasedYear;
    private String duration;
    private Set<SubMasterDataDto> genre;
    private Set<SubMasterDataDto> languages;
    private SubMasterDataDto rating;
    private Set<StarringDto> starring;
}
