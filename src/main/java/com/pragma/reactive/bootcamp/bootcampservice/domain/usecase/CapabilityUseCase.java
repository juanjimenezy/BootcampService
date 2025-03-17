package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.api.ICapabilityServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.ICapabilityPersistencePort;
import reactor.core.publisher.Mono;

public class CapabilityUseCase implements ICapabilityServicePort {

    private final ICapabilityPersistencePort capabilityPersistencePort;

    public CapabilityUseCase(ICapabilityPersistencePort capabilityPersistencePort) {
        this.capabilityPersistencePort = capabilityPersistencePort;
    }

    @Override
    public Mono<Capability> getCapability(Long capabilityId) {
        return capabilityPersistencePort.getCapability(capabilityId);
    }
}
