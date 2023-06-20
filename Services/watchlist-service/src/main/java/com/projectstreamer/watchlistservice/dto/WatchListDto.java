package com.projectstreamer.watchlistservice.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WatchListDto {
    private Long id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private Long account;
    private Set<ItemDto> items;
}
