package com.projectstreamer.moviesservice.service.serviceImpl;

import com.projectstreamer.moviesservice.entity.Language;
import com.projectstreamer.moviesservice.exception.exceptions.CustomException;
import com.projectstreamer.moviesservice.exception.exceptions.CustomNotFoundException;
import com.projectstreamer.moviesservice.repository.LanguageRepository;
import com.projectstreamer.moviesservice.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository repository;

    @Override
    public Long createLanguage(Language language) {
        if(repository.findByTitle(language.getTitle()).isPresent())
            throw new CustomException("Language Already Exist");
        return repository.save(language).getId();
    }

    @Override
    public Language getLanguageByTitle(String title) {
        Optional<Language> language=repository.findByTitle(title);
        if(!language.isPresent())
            throw new CustomException("Language Not Exist");
        return language.get();
    }

    @Override
    public List<Language> getAllLanguage() {
        return repository.findAll();
    }

    @Override
    public void updateLanguage(Language language) {
        if(repository.getByTitleAndIdNot(language.getTitle(),language.getId()).isPresent())
            throw new CustomException("language Already Exist");
        repository.save(language);
    }

    @Override
    public void deleteLanguageById(Long id) {
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new CustomNotFoundException("Language Id Not Found");
    }
}
