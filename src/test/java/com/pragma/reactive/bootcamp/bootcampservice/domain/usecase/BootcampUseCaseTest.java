package com.pragma.reactive.bootcamp.bootcampservice.domain.usecase;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampObject;
import com.pragma.reactive.bootcamp.bootcampservice.domain.spi.IBootcampPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BootcampUseCaseTest {

    @Mock
    private IBootcampPersistencePort bootcampPersistencePort;

    @InjectMocks
    private BootcampUseCase bootcampUseCase;

    private BootcampObject bootcamp;

    @BeforeEach
    void setUp() {
        bootcamp = new BootcampObject(1L, "Bootcamp Java", "Spring Boot avanzado");
    }

    @Test
    void testSave() {
        when(bootcampPersistencePort.save(bootcamp)).thenReturn(Mono.just(bootcamp));

        StepVerifier.create(bootcampUseCase.save(bootcamp))
                .expectNext(bootcamp)
                .verifyComplete();

        verify(bootcampPersistencePort).save(bootcamp);
    }

    @Test
    void testFindById() {
        Long id = 1L;
        when(bootcampPersistencePort.findById(id)).thenReturn(Mono.just(bootcamp));

        StepVerifier.create(bootcampUseCase.findById(id))
                .expectNext(bootcamp)
                .verifyComplete();

        verify(bootcampPersistencePort).findById(id);
    }

    @Test
    void testFindAllAsc() {
        int page = 0, size = 10, offset = page * size;
        when(bootcampPersistencePort.findAllPageAsc(size, offset)).thenReturn(Flux.just(bootcamp));

        StepVerifier.create(bootcampUseCase.findAll(page, size, true))
                .expectNext(bootcamp)
                .verifyComplete();

        verify(bootcampPersistencePort).findAllPageAsc(size, offset);
    }

    @Test
    void testFindAllDesc() {
        int page = 0, size = 10, offset = page * size;
        when(bootcampPersistencePort.findAllPageDesc(size, offset)).thenReturn(Flux.just(bootcamp));

        StepVerifier.create(bootcampUseCase.findAll(page, size, false))
                .expectNext(bootcamp)
                .verifyComplete();

        verify(bootcampPersistencePort).findAllPageDesc(size, offset);
    }
}
