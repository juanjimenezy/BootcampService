package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.ICapabilityPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.input.rest.service.CapabilityService;
import reactor.core.publisher.Mono;

public class CapabilityAdapter implements ICapabilityPersistencePort {

    private final CapabilityService capabilityService;

    public CapabilityAdapter(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @Override
    public Mono<Capability> getCapability(Long capabilityId) {
        return capabilityService.getCapability(capabilityId);
    }
}
