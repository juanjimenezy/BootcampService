package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity.BootcampCapabilitiesEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IBootcampCapabilitiesRepository extends ReactiveCrudRepository<BootcampCapabilitiesEntity, Long> {
    Flux<BootcampCapabilitiesEntity> findAllByBootcampId(Long bootcampId);
}
