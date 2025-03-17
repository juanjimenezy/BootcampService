package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampCapabilitiesPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper.IBootcampCapabilitiesEntityMapper;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository.IBootcampCapabilitiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class BootcampCapabilitiesJpaAdapter implements IBootcampCapabilitiesPersistencePort {

    private final IBootcampCapabilitiesRepository bootcampCapabilitiesRepository;
    private final IBootcampCapabilitiesEntityMapper bootcampCapabilitiesEntityMapper;

    @Override
    public Flux<BootcampCapabilitiesObject> saveAll(List<BootcampCapabilitiesObject> bootcampCapabilitiesObject) {
        return bootcampCapabilitiesRepository.saveAll(bootcampCapabilitiesEntityMapper.toEntityList(bootcampCapabilitiesObject))
                .map(bootcampCapabilitiesEntityMapper::toObject);
    }

    @Override
    public Flux<BootcampCapabilitiesObject> findByBootcampId(Long bootcampId) {
        return bootcampCapabilitiesRepository.findAllByBootcampId(bootcampId)
                .map(bootcampCapabilitiesEntityMapper::toObject);
    }
}
