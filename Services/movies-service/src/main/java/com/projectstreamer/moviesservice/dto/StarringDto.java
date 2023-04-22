package com.projectstreamer.moviesservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarringDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String about;
    private String imageUrl;
}
