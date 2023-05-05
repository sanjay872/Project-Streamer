package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query("SELECT m FROM Movie m WHERE ( (m.title LIKE CONCAT('%',?1,'%')) OR (m.title != NULL) ) AND ( (m.releasedYear >= ?2) OR (m.releasedYear == NULL) ) AND ( (m.genre == NULL) OR (?3 IN COALESCE(m.genre)) ) AND ( (m.rating >= ?4) OR (m.rating == NULL) ) AND ( (m.language == NULL) OR (?5 IN COALESCE(language)) ) ")
    Page<Movie> getMoviesByFilter(String title, String releasedYear, String genre, String rating, String language, Pageable pageable);
}
