package com.projectstreamer.watchlistservice.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String userId;
    private Set<WatchListDto> watchList;
}
