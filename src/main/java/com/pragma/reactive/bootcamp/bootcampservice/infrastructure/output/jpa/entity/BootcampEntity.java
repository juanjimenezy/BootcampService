package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "bootcamps")
@Getter
@Setter
@RequiredArgsConstructor
public class BootcampEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
