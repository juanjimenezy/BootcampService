package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.service;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.ICapabilityPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CapabilityService implements ICapabilityPersistencePort {

    private final WebClient webClient;

    @Override
    public Mono<Capability> getCapability(Long capabilityId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/capability/{id}").build(capabilityId))
                .retrieve()
                .bodyToMono(Capability.class)
                .onErrorResume(e -> {
                    System.err.println("Error al consumir el API: " + e.getMessage());
                    return Mono.empty();
                });
    }
}
