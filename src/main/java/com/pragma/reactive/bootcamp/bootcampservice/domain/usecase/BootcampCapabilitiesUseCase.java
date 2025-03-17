package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampCapabilitiesServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampCapabilitiesPersistencePort;
import reactor.core.publisher.Flux;

import java.util.List;

public class BootcampCapabilitiesUseCase implements IBootcampCapabilitiesServicePort {

    private final IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort;

    public BootcampCapabilitiesUseCase(IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort) {
        this.bootcampCapabilitiesPersistencePort = bootcampCapabilitiesPersistencePort;
    }

    @Override
    public Flux<BootcampCapabilitiesObject> saveAll(List<BootcampCapabilitiesObject> bootcampCapabilitiesObject) {
        return bootcampCapabilitiesPersistencePort.saveAll(bootcampCapabilitiesObject);
    }

    @Override
    public Flux<BootcampCapabilitiesObject> findByBootcampId(Long bootcampId) {
        return bootcampCapabilitiesPersistencePort.findByBootcampId(bootcampId);
    }
}
