package com.projectstreamer.watchlistservice.dataMapper;

import com.projectstreamer.watchlistservice.dto.ItemCategoryDto;
import com.projectstreamer.watchlistservice.entity.ItemCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemCategoryDataMapper {
    ItemCategory ItemCategoryDtoToItemCategory(ItemCategoryDto itemCategoryDto);
    ItemCategoryDto ItemCategoryToItemCategoryDto(ItemCategory itemCategory);
}
