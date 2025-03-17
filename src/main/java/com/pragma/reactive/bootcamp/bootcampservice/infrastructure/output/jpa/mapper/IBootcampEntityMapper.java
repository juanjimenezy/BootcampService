package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampObject;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity.BootcampEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IBootcampEntityMapper {
    BootcampEntity toEntity(BootcampObject bootcampObject);
    BootcampObject toObject(BootcampEntity bootcampEntity);
}
