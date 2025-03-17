package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.controller;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.handler.ICapabilityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bootcamp-capability")
@RequiredArgsConstructor
public class CapabilitiesController {

    private final ICapabilityHandler capabilityHandler;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CapabilityResponseDTO> getCapabilities(@PathVariable Long id) {
        return capabilityHandler.getCapabilities(id);
    }
}
