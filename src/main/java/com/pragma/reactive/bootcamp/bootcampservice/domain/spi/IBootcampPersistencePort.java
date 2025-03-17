package com.pragma.reactive.bootcamp.bootcampservice.domain.spi;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampObject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcampPersistencePort {
    Mono<BootcampObject> save(BootcampObject bootcampObject);
    Mono<BootcampObject> findById(Long id);
    Flux<BootcampObject> findAll();
    Flux<BootcampObject> findAllPageAsc(int limit, int offset);
    Flux<BootcampObject> findAllPageDesc(int limit, int offset);
}
