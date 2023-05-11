package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Long> {

    Optional<Language> findByTitle(String title);

    Optional<Object> getByTitleAndIdNot(String title, Long id);
}
