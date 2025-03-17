package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampCapabilitiesResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.IBootcampCapabilitiesResponseMapper;
import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampCapabilitiesServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class BootcampCapabilitiesHandler implements IBootcampCapabilitiesHandler {

    private final IBootcampCapabilitiesServicePort bootcampCapabilitiesServicePort;
    private final IBootcampCapabilitiesResponseMapper bootcampCapabilitiesResponseMapper;

    public BootcampCapabilitiesHandler(IBootcampCapabilitiesServicePort bootcampCapabilitiesServicePort, IBootcampCapabilitiesResponseMapper bootcampCapabilitiesResponseMapper) {
        this.bootcampCapabilitiesServicePort = bootcampCapabilitiesServicePort;
        this.bootcampCapabilitiesResponseMapper = bootcampCapabilitiesResponseMapper;
    }

    @Override
    public Flux<BootcampCapabilitiesResponseDTO> createBootcampCapabilities(List<BootcampCapabilitiesObject> bootcampCapabilitiesObject) {
        return bootcampCapabilitiesServicePort.saveAll(bootcampCapabilitiesObject)
                .map(bootcampCapabilitiesResponseMapper::toDTO);
    }

    @Override
    public Flux<BootcampCapabilitiesResponseDTO> getByBootcampId(Long bootcampId) {
        return bootcampCapabilitiesServicePort.findByBootcampId(bootcampId)
                .map(bootcampCapabilitiesResponseMapper::toDTO);
    }
}
