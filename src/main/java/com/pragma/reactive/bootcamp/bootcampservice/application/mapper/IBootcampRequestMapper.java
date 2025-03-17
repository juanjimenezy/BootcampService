package com.pragma.reactive.bootcamp.bootcampservice.application.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.request.BootcampRequestDTO;
import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IBootcampRequestMapper {
    BootcampObject toObject(BootcampRequestDTO bootcampRequestDTO);
    BootcampRequestDTO toDTO(BootcampObject bootcampObject);
}
