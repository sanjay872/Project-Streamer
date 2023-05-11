package com.projectstreamer.moviesservice.facade;


import com.projectstreamer.moviesservice.dto.LanguageDto;

import java.util.List;

public interface LanguageFacade {
    Long createLanguage(LanguageDto languageDto);

    LanguageDto getLanguageByTitle(String title);

    List<LanguageDto> getAllLanguage();

    void updateLanguage(LanguageDto languageDto);

    void deleteLanguageById(Long id);
}
