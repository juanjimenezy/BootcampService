package com.pragma.reactive.bootcamp.bootcampservice.application.dto.response;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Technology;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CapabilityResponseDTO {
    private Long id;
    private String name;
    private String description;
    private List<Technology> technologies;
}
