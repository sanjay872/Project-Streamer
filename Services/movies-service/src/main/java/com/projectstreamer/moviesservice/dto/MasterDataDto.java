package com.projectstreamer.moviesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MasterDataDto {
    private Long id;
    private String name;
    private String code;
    private String description;
}
