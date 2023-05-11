package com.projectstreamer.moviesservice.datamapper;

import com.projectstreamer.moviesservice.dto.LanguageDto;
import com.projectstreamer.moviesservice.entity.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageDataMapper {
    Language languageDtoToLanguage(LanguageDto languageDto);
    LanguageDto languageToLanguageDto(Language language);
}
