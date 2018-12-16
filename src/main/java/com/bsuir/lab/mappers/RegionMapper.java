package com.bsuir.lab.mappers;

import com.bsuir.lab.persistence.dto.RegionDto;
import com.bsuir.lab.persistence.entity.Region;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class RegionMapper {

    public RegionDto toRegionDto(Region region) {
        RegionDto regionDto = new RegionDto();

        regionDto.setId(region.getId());
        regionDto.setName(region.getName());

        return regionDto;
    }
}
