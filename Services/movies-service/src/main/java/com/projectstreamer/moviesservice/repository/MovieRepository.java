package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    
//    Page<Movie> getMoviesByFilter(String title, String releasedYear, String genre, String rating, String language, Pageable pageable);
}
