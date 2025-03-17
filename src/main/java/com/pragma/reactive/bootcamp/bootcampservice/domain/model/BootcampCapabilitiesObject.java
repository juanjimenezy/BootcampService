package com.pragma.reactive.bootcamp.bootcampservice.domain.model;

public class BootcampCapabilitiesObject {
    private Long bootcampId;
    private Long capabilityId;

    public BootcampCapabilitiesObject(Long bootcampId, Long capabilityId) {
        this.bootcampId = bootcampId;
        this.capabilityId = capabilityId;
    }

    public Long getBootcampId() {
        return bootcampId;
    }

    public void setBootcampId(Long bootcampId) {
        this.bootcampId = bootcampId;
    }

    public Long getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(Long capabilityId) {
        this.capabilityId = capabilityId;
    }
}
