package com.projectstreamer.moviesservice.dtoService;


import com.projectstreamer.moviesservice.dto.LanguageDto;

import java.util.List;

public interface LanguageDtoService {
    Long createLanguage(LanguageDto languageDto);

    LanguageDto getLanguageByTitle(String title);

    List<LanguageDto> getAllLanguage();

    void updateLanguage(LanguageDto languageDto);

    void deleteLanguageById(Long id);
}
