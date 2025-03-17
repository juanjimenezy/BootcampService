package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity.BootcampEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBootcampRepository extends ReactiveCrudRepository<BootcampEntity, Long> {
}
