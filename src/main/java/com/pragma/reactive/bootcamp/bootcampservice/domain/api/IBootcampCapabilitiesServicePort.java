package com.pragma.reactive.bootcamp.bootcampservice.domain.api;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import reactor.core.publisher.Flux;

import java.util.List;

public interface IBootcampCapabilitiesServicePort {
    Flux<BootcampCapabilitiesObject> saveAll(List<BootcampCapabilitiesObject> bootcampCapabilitiesObject);
    Flux<BootcampCapabilitiesObject> findByBootcampId(Long bootcampId);
}
