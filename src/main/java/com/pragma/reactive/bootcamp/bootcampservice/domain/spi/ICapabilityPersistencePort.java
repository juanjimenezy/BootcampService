package com.pragma.reactive.bootcamp.bootcampservice.domain.spi;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import reactor.core.publisher.Mono;

public interface ICapabilityPersistencePort {
    Mono<Capability> getCapability(Long capabilityId);
}
