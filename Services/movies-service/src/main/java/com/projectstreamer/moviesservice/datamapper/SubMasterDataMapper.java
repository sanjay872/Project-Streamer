package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.SubMasterDataDto;
import com.projectstreamer.moviesservice.entity.SubMasterData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {MasterDataMapper.class})
public interface SubMasterDataMapper {
    SubMasterData subMasterDataDtoToSubMasterData(SubMasterDataDto subMasterDataDto);
    SubMasterDataDto subMasterDataToSubMasterDataDto(SubMasterData subMasterData);
}
