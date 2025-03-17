package com.pragma.reactive.bootcamp.bootcampservice.application.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.application.dto.response.CapabilityResponseDTO;
import com.pragma.reactive.bootcamp.bootcampservice.domain.model.Capability;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface ICapabilityResponseMapper {
    Capability toObject(CapabilityResponseDTO capabilityResponseDTO);
    CapabilityResponseDTO toDTO(Capability capability);
    List<CapabilityResponseDTO> toDTO(List<Capability> capabilities);
}
