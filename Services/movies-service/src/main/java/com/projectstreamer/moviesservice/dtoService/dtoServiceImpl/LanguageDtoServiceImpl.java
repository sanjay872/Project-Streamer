package com.projectstreamer.moviesservice.dtoService.dtoServiceImpl;

import com.projectstreamer.moviesservice.datamapper.LanguageDataMapper;
import com.projectstreamer.moviesservice.dto.LanguageDto;
import com.projectstreamer.moviesservice.dtoService.LanguageDtoService;
import com.projectstreamer.moviesservice.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageDtoServiceImpl implements LanguageDtoService {

    @Autowired
    private LanguageService service;

    @Autowired
    private LanguageDataMapper dataMapper;

    @Override
    public Long createLanguage(LanguageDto languageDto) {
        return service.createLanguage(dataMapper.languageDtoToLanguage(languageDto));
    }

    @Override
    public LanguageDto getLanguageByTitle(String title) {
        return dataMapper.languageToLanguageDto(service.getLanguageByTitle(title));
    }

    @Override
    public List<LanguageDto> getAllLanguage() {
        return service.getAllLanguage().stream().map(dataMapper::languageToLanguageDto).collect(Collectors.toList());
    }

    @Override
    public void updateLanguage(LanguageDto languageDto) {
        service.updateLanguage(dataMapper.languageDtoToLanguage(languageDto));
    }

    @Override
    public void deleteLanguageById(Long id) {
        service.deleteLanguageById(id);
    }
}
