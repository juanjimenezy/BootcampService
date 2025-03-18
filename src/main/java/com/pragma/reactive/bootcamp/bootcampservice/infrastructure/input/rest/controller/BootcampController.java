package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.controller;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.handler.IBootcampHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bootcamp")
@RequiredArgsConstructor
@Tag(name = "Bootcamp", description = "Gestion bootcamp")
public class BootcampController {

    private final IBootcampHandler bootcampHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create bootcamp", description = "this endpoint save bootcamp")
    public Mono<BootcampResponseDTO> save(@Valid @RequestBody BootcampRequestDTO bootcampRequestDTO) {
        return bootcampHandler.createBootcamp(bootcampRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all bootcamp", description = "this endpoint return a list bootcamp")
    public Flux<BootcampResponseDTO> findAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "true") boolean asc) {
        return bootcampHandler.getAllBootcamps(page, size, asc);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get bootcamp by id", description = "this endpoint return bootcamp")
    public Mono<BootcampResponseDTO> findById(@PathVariable Long id) {
        return bootcampHandler.getBootcampById(id);
    }

}
