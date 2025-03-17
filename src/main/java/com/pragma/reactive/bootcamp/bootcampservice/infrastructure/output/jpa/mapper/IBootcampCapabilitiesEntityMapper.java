package com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.mapper;

import com.pragma.reactive.bootcamp.bootcampservice.domain.model.BootcampCapabilitiesObject;
import com.pragma.reactive.bootcamp.bootcampservice.infrastructure.output.jpa.entity.BootcampCapabilitiesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Primary
public interface IBootcampCapabilitiesEntityMapper {
    BootcampCapabilitiesObject toObject(BootcampCapabilitiesEntity bootcampCapabilitiesEntity);
    BootcampCapabilitiesEntity toEntity(BootcampCapabilitiesObject bootcampCapabilitiesObject);
    List<BootcampCapabilitiesEntity> toEntityList(List<BootcampCapabilitiesObject> bootcampCapabilitiesObjectList);
}
