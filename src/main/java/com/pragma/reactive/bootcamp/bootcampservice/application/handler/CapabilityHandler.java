package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.ICapabilityResponseMapper;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.ICapabilityPersistencePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CapabilityHandler implements ICapabilityHandler {

    private final ICapabilityPersistencePort capabilityPersistencePort;
    private final ICapabilityResponseMapper capabilityResponseMapper;

    public CapabilityHandler(ICapabilityPersistencePort capabilityPersistencePort, ICapabilityResponseMapper capabilityResponseMapper) {
        this.capabilityPersistencePort = capabilityPersistencePort;
        this.capabilityResponseMapper = capabilityResponseMapper;
    }

    @Override
    public Mono<CapabilityResponseDTO> getCapabilities(Long capabilityId) {
        return capabilityPersistencePort.getCapability(capabilityId)
                .map(capabilityResponseMapper::toDTO);
    }
}
