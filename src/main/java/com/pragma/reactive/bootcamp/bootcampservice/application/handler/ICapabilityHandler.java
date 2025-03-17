package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.CapabilityResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ICapabilityHandler {
    Mono<CapabilityResponseDTO> getCapabilities(Long capabilityId);
}
