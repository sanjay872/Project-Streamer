package com.projectstreamer.watchlistservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryDto {
    private Long id;
    private String name;
    private String code;
    private String description;
}
