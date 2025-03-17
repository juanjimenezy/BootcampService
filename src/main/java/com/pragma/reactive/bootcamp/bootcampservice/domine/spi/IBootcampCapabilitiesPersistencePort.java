package com.pragma.reactive.bootcamp.bootcampservice.domine.spi;

import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampCapabilitiesObject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcampCapabilitiesPersistencePort {
    Mono<BootcampCapabilitiesObject> save(BootcampCapabilitiesObject bootcampCapabilitiesObject);
    Flux<BootcampCapabilitiesObject> findByBootcampId(Long bootcampId);
}
