package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Technology;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.ICapabilityPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CapabilityUseCaseTest {

    @Mock
    private ICapabilityPersistencePort capabilityPersistencePort;

    @InjectMocks
    private CapabilityUseCase capabilityUseCase;

    private Capability capability;

    @BeforeEach
    void setUp() {
        Technology technology = new Technology(1L, "Spring Boot");
        List<Technology> technologies = new ArrayList<>();
        technologies.add(technology);
        capability = new Capability(1L, "Java", "Desarrollo backend con Java y Spring Boot", technologies);
    }

    @Test
    void testGetCapability() {
        Long id = 1L;
        when(capabilityPersistencePort.getCapability(id)).thenReturn(Mono.just(capability));

        StepVerifier.create(capabilityUseCase.getCapability(id))
                .expectNext(capability)
                .verifyComplete();

        verify(capabilityPersistencePort).getCapability(id);
    }
}
