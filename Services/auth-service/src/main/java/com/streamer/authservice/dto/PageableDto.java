package com.streamer.authservice.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableDto<E>{
    private List<E> elements;
    private long totalElements;
}
