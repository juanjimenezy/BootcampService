package com.pragma.reactive.bootcamp.bootcampservice.application.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.domine.model.BootcampObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IBootcampResponseMapper {
    BootcampObject toObject(BootcampResponseDTO bootcampResponseDTO);
    BootcampResponseDTO toDTO(BootcampObject bootcampObject);
}
