package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.IBootcampRequestMapper;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.IBootcampResponseMapper;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.ICapabilityResponseMapper;
import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampCapabilitiesServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.api.ICapabilityServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BootcampHandler implements IBootcampHandler {
    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampCapabilitiesServicePort bootcampCapabilitiesServicePort;
    private final ICapabilityServicePort capabilityServicePort;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;
    private final ICapabilityResponseMapper capabilityResponseMapper;

    public BootcampHandler(IBootcampServicePort bootcampServicePort, IBootcampCapabilitiesServicePort bootcampCapabilitiesServicePort, ICapabilityServicePort capabilityServicePort, IBootcampRequestMapper bootcampRequestMapper, IBootcampResponseMapper bootcampResponseMapper, ICapabilityResponseMapper capabilityResponseMapper) {
        this.bootcampServicePort = bootcampServicePort;
        this.bootcampCapabilitiesServicePort = bootcampCapabilitiesServicePort;
        this.capabilityServicePort = capabilityServicePort;
        this.bootcampRequestMapper = bootcampRequestMapper;
        this.bootcampResponseMapper = bootcampResponseMapper;
        this.capabilityResponseMapper = capabilityResponseMapper;
    }

    @Override
    public Mono<BootcampResponseDTO> createBootcamp(BootcampRequestDTO bootcampRequestDTO) {
        return bootcampServicePort.save(bootcampRequestMapper.toObject(bootcampRequestDTO))
                .flatMap(bootCampSave -> {
                    List<BootcampCapabilitiesObject> capabilities = bootcampRequestDTO.getCapabilitiesId().stream().map(capId -> new BootcampCapabilitiesObject(bootCampSave.getId(), capId)).toList();
                    return bootcampCapabilitiesServicePort.saveAll(capabilities).then(Mono.just(bootCampSave));
                })
                .map(bootcampResponseMapper::toDTO);
    }

    @Override
    public Flux<BootcampResponseDTO> getAllBootcamps(int page, int size, boolean asc) {
        return bootcampServicePort.findAll(page,size,asc)
                .flatMap(bootcamp -> bootcampCapabilitiesServicePort.findByBootcampId(bootcamp.getId())
                        .flatMap(botCap -> capabilityServicePort.getCapability(botCap.getCapabilityId()))
                        .collectList()
                        .map(capList -> {
                            BootcampResponseDTO dto = bootcampResponseMapper.toDTO(bootcamp);
                            dto.setBootcampCapabilities(capabilityResponseMapper.toDTO(capList));
                            return dto;
                        })
                );
    }

    @Override
    public Mono<BootcampResponseDTO> getBootcampById(long id) {
        return bootcampServicePort.findById(id)
                .flatMap(bootcamp -> bootcampCapabilitiesServicePort.findByBootcampId(bootcamp.getId())
                        .flatMap(botCap -> capabilityServicePort.getCapability(botCap.getCapabilityId()))
                        .collectList()
                        .map(capList -> {
                            BootcampResponseDTO dto = bootcampResponseMapper.toDTO(bootcamp);
                            dto.setBootcampCapabilities(capabilityResponseMapper.toDTO(capList));
                            return dto;
                        })
                );
    }
}
