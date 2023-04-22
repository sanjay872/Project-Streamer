package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.StarringDto;
import com.projectstreamer.moviesservice.entity.Starring;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StarringDataMapper {
    Starring starringDtoToStarring(StarringDto starringDto);
    StarringDto starringToStarringDto(Starring starring);
}
