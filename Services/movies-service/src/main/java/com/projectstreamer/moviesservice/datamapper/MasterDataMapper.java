package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.MasterDataDto;
import com.projectstreamer.moviesservice.entity.MasterData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MasterDataMapper {
    MasterDataDto masterDataToMasterDataDto(MasterData masterData);
    MasterData masterDataDtoToMasterData(MasterDataDto masterDataDto);
}
