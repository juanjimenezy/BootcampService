package com.pragma.reactive.bootcamp.bootcampservice.application.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.BootcampCapabilitiesResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IBootcampCapabilitiesResponseMapper {
    BootcampCapabilitiesObject toObject(BootcampCapabilitiesResponseDTO bootcampCapabilitiesResponseDTO);
    BootcampCapabilitiesResponseDTO toDTO(BootcampCapabilitiesObject bootcampCapabilitiesObject);
}
