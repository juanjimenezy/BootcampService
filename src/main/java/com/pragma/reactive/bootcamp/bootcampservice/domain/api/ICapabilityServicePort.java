package com.pragma.reactive.bootcamp.bootcampservice.domain.api;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import reactor.core.publisher.Mono;

public interface ICapabilityServicePort {
    Mono<Capability> getCapability(Long capabilityId);
}
