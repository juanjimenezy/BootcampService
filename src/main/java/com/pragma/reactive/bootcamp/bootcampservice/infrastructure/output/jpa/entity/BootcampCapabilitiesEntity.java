package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "bootcamp_capabilities")
@Getter
@Setter
@RequiredArgsConstructor
public class BootcampCapabilitiesEntity {
    private Long bootcampId;
    private Long capabilityId;
}
