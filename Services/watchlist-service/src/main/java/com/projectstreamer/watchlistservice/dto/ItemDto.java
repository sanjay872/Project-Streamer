package com.projectstreamer.watchlistservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long dataId;
    private Date createdDate;
    private boolean isFavorite;
    private ItemCategoryDto itemCategory;
}
