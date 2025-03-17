package com.pragma.reactive.bootcamp.bootcampservice.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BootcampResponseDTO {
    private Long id;
    private String name;
    private String description;
    private List<BootcampCapabilitiesResponseDTO> bootcampCapabilities;
}
