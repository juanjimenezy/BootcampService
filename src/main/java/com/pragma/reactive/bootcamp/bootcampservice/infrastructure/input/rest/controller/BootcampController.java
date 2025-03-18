package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.controller;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.PagueableRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.handler.IBootcampHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bootcamp")
@RequiredArgsConstructor
public class BootcampController {

    private final IBootcampHandler bootcampHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BootcampResponseDTO> save(@Valid @RequestBody BootcampRequestDTO bootcampRequestDTO) {
        return bootcampHandler.createBootcamp(bootcampRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BootcampResponseDTO> findAll(@Valid @RequestBody PagueableRequestDTO pageable) {
        return bootcampHandler.getAllBootcamps(pageable.getPage(),pageable.getSize(),pageable.isAsc());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BootcampResponseDTO> findById(@PathVariable Long id) {
        return bootcampHandler.getBootcampById(id);
    }

}
