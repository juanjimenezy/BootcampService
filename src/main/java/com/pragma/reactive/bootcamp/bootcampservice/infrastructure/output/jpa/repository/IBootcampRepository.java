package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository;

import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity.BootcampEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IBootcampRepository extends ReactiveCrudRepository<BootcampEntity, Long> {

    @Query("SELECT * FROM bootcamps ORDER BY name ASC LIMIT :limit OFFSET :offset")
    Flux<BootcampEntity> findAllPageAsc(int limit, int offset);

    @Query("SELECT * FROM bootcamps ORDER BY name DESC LIMIT :limit OFFSET :offset")
    Flux<BootcampEntity> findAllPageDesc(int limit, int offset);
}
