package com.pragma.reactive.bootcamp.bootcampservice.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BootcampRequestDTO {
    private Long id;
    private String name;
    private String description;
    private List<Long> capabilitiesId;
}
