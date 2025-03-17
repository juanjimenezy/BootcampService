package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampPersistencePort;
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
    public Flux<BootcampObject> findAll(int page, int size, boolean asc) {
        int offset = page*size;

        if (asc){
            return bootcampPersistencePort.findAllPageAsc(size,offset);
        }

        return bootcampPersistencePort.findAllPageDesc(size,offset);
    }
}
