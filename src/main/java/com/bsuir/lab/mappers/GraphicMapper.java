//package com.bsuir.lab.mappers;
//
//import com.bsuir.lab.persistence.dto.GraphicDto;
//import org.mapstruct.Mapper;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Mapper(componentModel = "spring")
//public class GraphicMapper {
//
//    public GraphicDto toGraphicDto() {
//        Set<String> sensorDates = new HashSet<>();
//        region.getSensors()
//                .forEach(s -> s.getDataRegisters()
//                        .forEach(d -> sensorDates.add(String
//                                .valueOf(d.getDate()).substring(0, String.valueOf(d.getDate()).indexOf(" ")))));
//        RegionDto regionDto = new RegionDto();
//
//        regionDto.setId(region.getId());
//        regionDto.setName(region.getName());
//        regionDto.setDataRegisterDate(sensorDates);
//    }
