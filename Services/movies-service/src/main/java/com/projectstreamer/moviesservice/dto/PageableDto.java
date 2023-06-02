package com.projectstreamer.moviesservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableDto<E>{
    private List<E> elements;
    private long totalElements;
}
