package com.projectstreamer.moviesservice.repository;

import com.projectstreamer.moviesservice.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
   Page<Movie> findMovieByTitleIgnoreCaseContainingOrReleasedYearOrRatingOrGenreOrLanguages(String title,String releasedYear,Float rating, String genre, String language, Pageable pageable);
}
