package com.pragma.reactive.bootcamp.bootcampservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagueableRequestDTO {
    private int page;
    private int size;
    private boolean asc;
}
