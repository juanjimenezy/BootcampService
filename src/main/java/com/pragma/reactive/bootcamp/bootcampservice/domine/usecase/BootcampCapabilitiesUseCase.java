package com.pragma.reactive.bootcamp.bootcampservice.domine.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domine.api.IBootcampCapabilitiesServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampCapabilitiesObject;
import com.pragma.reactive.bootcamp.bootcampservice.domine.spi.IBootcampCapabilitiesPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BootcampCapabilitiesUseCase implements IBootcampCapabilitiesServicePort {

    private final IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort;

    public BootcampCapabilitiesUseCase(IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort) {
        this.bootcampCapabilitiesPersistencePort = bootcampCapabilitiesPersistencePort;
    }

    @Override
    public Mono<BootcampCapabilitiesObject> save(BootcampCapabilitiesObject bootcampCapabilitiesObject) {
        return bootcampCapabilitiesPersistencePort.save(bootcampCapabilitiesObject);
    }

    @Override
    public Flux<BootcampCapabilitiesObject> findByBootcampId(Long bootcampId) {
        return bootcampCapabilitiesPersistencePort.findByBootcampId(bootcampId);
    }
}
