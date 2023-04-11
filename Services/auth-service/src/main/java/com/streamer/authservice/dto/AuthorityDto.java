package com.streamer.authservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
    private Long id;
    private String authority;
}
