package com.pragma.reactive.bootcamp.bootcampservice.domine.spi;

import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampObject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcampPersistencePort {
    Mono<BootcampObject> save(BootcampObject bootcampObject);
    Mono<BootcampObject> findById(Long id);
    Flux<BootcampObject> findAll();
}
