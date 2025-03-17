package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.configuration;

import com.pragma.reactive.bootcamp.bootcampservice.domine.api.IBootcampServicePort;
import com.pragma.reactive.bootcamp.bootcampservice.domine.spi.IBootcampPersistencePort;
import com.pragma.reactive.bootcamp.bootcampservice.domine.usecase.BootcampUseCase;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.adapter.BootcampJpaAdapter;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper.IBootcampEntityMapper;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.repository.IBootcampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IBootcampRepository bootcampRepository;
    private final IBootcampEntityMapper bootcampEntityMapper;

    @Bean
    public IBootcampPersistencePort bootcampPersistencePort() {
        return new BootcampJpaAdapter(bootcampRepository, bootcampEntityMapper);
    }

    @Bean
    public IBootcampServicePort bootcampServicePort() {
        return new BootcampUseCase(bootcampPersistencePort());
    }
}
