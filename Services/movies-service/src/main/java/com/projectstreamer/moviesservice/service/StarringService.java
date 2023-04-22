package com.projectstreamer.moviesservice.service;

import com.projectstreamer.moviesservice.entity.Starring;
import org.springframework.data.domain.Page;

public interface StarringService {
    Long createStarring(Starring starring);

    Page<Starring> getAllStarring(int pageNo, int pageSize);

    void updateStarring(Starring starring);

    void deleteStarring(Long id);
}
