package com.projectstreamer.watchlistservice.dataMapper;

import com.projectstreamer.watchlistservice.dto.ItemDto;
import com.projectstreamer.watchlistservice.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ItemCategoryDataMapper.class})
public interface ItemDataMapper {

    Item ItemDtoToItem(ItemDto itemDto);
    ItemDto ItemToItemDto(Item item);

}
