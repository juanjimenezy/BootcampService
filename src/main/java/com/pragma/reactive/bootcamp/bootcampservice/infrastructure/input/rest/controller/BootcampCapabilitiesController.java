package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.controller;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampCapabilitiesResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.handler.IBootcampCapabilitiesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/bootcamp-capabilities")
@RequiredArgsConstructor
public class BootcampCapabilitiesController {

    private final IBootcampCapabilitiesHandler bootcampCapabilitiesHandler;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootcampCapabilitiesResponseDTO> getCapabilities(@PathVariable Long id) {
        return bootcampCapabilitiesHandler.getByBootcampId(id);
    }

}
