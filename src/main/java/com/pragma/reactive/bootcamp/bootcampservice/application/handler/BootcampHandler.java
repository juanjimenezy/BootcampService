package com.pragma.reactive.bootcamp.bootcampservice.application.handler;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.IBootcampRequestMapper;
import com.pragma.reactive.bootcamp.bootcampservice.application.mapper.IBootcampResponseMapper;
import com.pragma.reactive.bootcamp.bootcampservice.domine.api.IBootcampServicePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootcampHandler implements IBootcampHandler {

    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;

    public BootcampHandler(IBootcampServicePort bootcampServicePort, IBootcampRequestMapper bootcampRequestMapper, IBootcampResponseMapper bootcampResponseMapper) {
        this.bootcampServicePort = bootcampServicePort;
        this.bootcampRequestMapper = bootcampRequestMapper;
        this.bootcampResponseMapper = bootcampResponseMapper;
    }

    @Override
    public Mono<BootcampResponseDTO> createBootcamp(BootcampRequestDTO bootcampRequestDTO) {
        return bootcampServicePort.save(bootcampRequestMapper.toObject(bootcampRequestDTO))
                .map(bootcampResponseMapper::toDTO);
    }

    @Override
    public Flux<BootcampResponseDTO> getAllBootcamps() {
        return bootcampServicePort.findAll()
                .map(bootcampResponseMapper::toDTO);
    }

    @Override
    public Mono<BootcampResponseDTO> getBootcampById(long id) {
        return bootcampServicePort.findById(id)
                .map(bootcampResponseMapper::toDTO);
    }
}
