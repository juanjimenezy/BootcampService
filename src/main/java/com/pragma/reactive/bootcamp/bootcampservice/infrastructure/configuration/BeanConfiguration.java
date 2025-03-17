package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.configuration;

import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampCapabilitiesServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.api.IBootcampServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampCapabilitiesPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.domain.usecase.BootcampCapabilitiesUseCase;
import com.pragma.reactive.bootcamp.bootcampservice.domain.usecase.BootcampUseCase;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter.BootcampCapabilitiesJpaAdapter;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter.BootcampJpaAdapter;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper.IBootcampCapabilitiesEntityMapper;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper.IBootcampEntityMapper;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository.IBootcampCapabilitiesRepository;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;
    private final IBootcampCapabilitiesRepository bootcampCapabilitiesRepository;
    private final IBootcampCapabilitiesEntityMapper bootcampCapabilitiesEntityMapper;

    @Bean
    public IBootcampPersistencePort bootcampPersistencePort() {
        return new BootcampJpaAdapter(bootcampRepository, bootcampEntityMapper);
    }

    @Bean
    public IBootcampServicePort bootcampServicePort() {
        return new BootcampUseCase(bootcampPersistencePort());
    }

    @Bean
    public IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort() {
        return new BootcampCapabilitiesJpaAdapter(bootcampCapabilitiesRepository, bootcampCapabilitiesEntityMapper);
    }

    @Bean
    public IBootcampCapabilitiesServicePort bootcampCapabilitiesServicePort() {
        return new BootcampCapabilitiesUseCase(bootcampCapabilitiesPersistencePort());
    }
}
