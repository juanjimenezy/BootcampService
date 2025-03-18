package com.pragma.reactive.bootcamp.bootcampservice.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BootcampRequestDTO {
    private Long id;

    @NotEmpty(message = "name cannot be null")
    private String name;

    @NotEmpty(message = "description cannot be null")
    private String description;

    @NotEmpty(message = "tecnologiesId cannot be null")
    private List<Long> capabilitiesId;
}
