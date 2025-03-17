package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampCapabilitiesResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public interface IBootcampCapabilitiesHandler {
    Flux<BootcampCapabilitiesResponseDTO> createBootcampCapabilities(List<BootcampCapabilitiesObject> bootcampCapabilitiesObject);
    Flux<BootcampCapabilitiesResponseDTO> getByBootcampId(Long bootcampId);
}
