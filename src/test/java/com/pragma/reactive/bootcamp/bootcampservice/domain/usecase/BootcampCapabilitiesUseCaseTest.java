package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampCapabilitiesPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BootcampCapabilitiesUseCaseTest {

    @Mock
    private IBootcampCapabilitiesPersistencePort bootcampCapabilitiesPersistencePort;

    @InjectMocks
    private BootcampCapabilitiesUseCase bootcampCapabilitiesUseCase;

    private List<BootcampCapabilitiesObject> bootcampCapabilitiesList;

    @BeforeEach
    void setUp() {
        bootcampCapabilitiesList = List.of(
                new BootcampCapabilitiesObject(1L, 101L),
                new BootcampCapabilitiesObject(1L, 102L),
                new BootcampCapabilitiesObject(1L, 103L)
        );
    }

    @Test
    void testSaveAll() {
        when(bootcampCapabilitiesPersistencePort.saveAll(bootcampCapabilitiesList))
                .thenReturn(Flux.fromIterable(bootcampCapabilitiesList));

        StepVerifier.create(bootcampCapabilitiesUseCase.saveAll(bootcampCapabilitiesList))
                .expectNextSequence(bootcampCapabilitiesList)
                .verifyComplete();

        verify(bootcampCapabilitiesPersistencePort).saveAll(bootcampCapabilitiesList);
    }

    @Test
    void testFindByBootcampId() {
        Long bootcampId = 1L;
        when(bootcampCapabilitiesPersistencePort.findByBootcampId(bootcampId))
                .thenReturn(Flux.fromIterable(bootcampCapabilitiesList));

        StepVerifier.create(bootcampCapabilitiesUseCase.findByBootcampId(bootcampId))
                .expectNextSequence(bootcampCapabilitiesList)
                .verifyComplete();

        verify(bootcampCapabilitiesPersistencePort).findByBootcampId(bootcampId);
    }
}
