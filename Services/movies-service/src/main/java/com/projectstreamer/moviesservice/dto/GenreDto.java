package com.projectstreamer.moviesservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDto {
    private Long id;
    private String title;
    private String description;
}
