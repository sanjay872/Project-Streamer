package com.projectstreamer.moviesservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LanguageDto {
    private Long id;
    private String title;
    private String description;
}
