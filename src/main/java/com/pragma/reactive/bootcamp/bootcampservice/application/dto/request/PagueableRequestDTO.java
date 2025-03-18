package com.pragma.reactive.bootcamp.bootcampservice.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagueableRequestDTO {
    @NotEmpty(message = "page cannot be null")
    private int page;

    @NotEmpty(message = "size cannot be null")
    private int size;

    @NotEmpty(message = "asc cannot be null")
    private boolean asc;
}
