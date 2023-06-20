package com.projectstreamer.watchlistservice.dtoService;

import com.projectstreamer.watchlistservice.dto.ItemCategoryDto;

import java.util.List;

public interface ItemCategoryDtoService {
    Long createItemCategory(ItemCategoryDto itemCategoryDto);

    List<ItemCategoryDto> getAllItemCategory();

    void updateItemCategory(ItemCategoryDto itemCategoryDto);

    void deleteItemCategory(Long id);
}
