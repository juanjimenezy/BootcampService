package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IBootcampHandler {
    Mono<BootcampResponseDTO> createBootcamp(BootcampRequestDTO bootcampRequestDTO);
    Flux<BootcampResponseDTO> getAllBootcamps();
    Mono<BootcampResponseDTO> getBootcampById(long id);
}
