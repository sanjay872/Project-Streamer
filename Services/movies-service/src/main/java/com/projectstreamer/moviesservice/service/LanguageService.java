package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Language;

import java.util.List;

public interface LanguageService {
    Long createLanguage(Language language);

    Language getLanguageByTitle(String Title);

    List<Language> getAllLanguage();

    void updateLanguage(Language language);

    void deleteLanguageById(Long id);
}
