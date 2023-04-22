package com.projectstreamer.moviesservice.facade;

import com.projectstreamer.moviesservice.dto.PageableDto;
import com.projectstreamer.moviesservice.dto.StarringDto;

public interface StarringFacade {
    Long createStarring(StarringDto starringDto);

    PageableDto getAllStarring(int pageNo, int pageSize);

    void updateStarring(StarringDto starringDto);

    void deleteStarring(Long id);
}
