package com.pragma.reactive.bootcamp.bootcampservice.domine.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domine.api.IBootcampServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampObject;
import com.pragma.reactive.bootcamp.bootcampservice.domine.spi.IBootcampPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BootcampUseCase implements IBootcampServicePort {

    private final IBootcampPersistencePort bootcampPersistencePort;

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }


    @Override
    public Mono<BootcampObject> save(BootcampObject bootcampObject) {
        return bootcampPersistencePort.save(bootcampObject);
    }

    @Override
    public Mono<BootcampObject> findById(Long id) {
        return bootcampPersistencePort.findById(id);
    }

    @Override
    public Flux<BootcampObject> findAll() {
        return bootcampPersistencePort.findAll();
    }
}
