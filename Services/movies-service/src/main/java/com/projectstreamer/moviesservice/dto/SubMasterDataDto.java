package com.projectstreamer.moviesservice.dto;

import com.projectstreamer.moviesservice.entity.MasterData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubMasterDataDto {
    private Long id;
    private String name;
    private String code;
    private MasterData masterData;
}
