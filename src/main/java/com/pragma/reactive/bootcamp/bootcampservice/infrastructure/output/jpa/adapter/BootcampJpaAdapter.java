package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper.IBootcampEntityMapper;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BootcampJpaAdapter implements IBootcampPersistencePort {

    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Override
    public Mono<BootcampObject> save(BootcampObject bootcampObject) {
        return bootcampRepository.save(bootcampEntityMapper.toEntity(bootcampObject))
                .map(bootcampEntityMapper::toObject);
    }

    @Override
    public Mono<BootcampObject> findById(Long id) {
        return bootcampRepository.findById(id)
                .map(bootcampEntityMapper::toObject);
    }

    @Override
    public Flux<BootcampObject> findAll() {
        return bootcampRepository.findAll()
                .map(bootcampEntityMapper::toObject);
    }

    @Override
    public Flux<BootcampObject> findAllPageAsc(int limit, int offset) {
        return bootcampRepository.findAllPageAsc(limit,offset)
                .map(bootcampEntityMapper::toObject);
    }

    @Override
    public Flux<BootcampObject> findAllPageDesc(int limit, int offset) {
        return bootcampRepository.findAllPageDesc(limit,offset)
                .map(bootcampEntityMapper::toObject);
    }
}
