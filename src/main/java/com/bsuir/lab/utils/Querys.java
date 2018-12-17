package com.bsuir.lab.utils;

public enum Querys {

    GET_ALL_REGIONS("from Region"),
    GET_ALL_SENSORS("from Sensor"),
    GET_ALL_DATA_REGISTERS("from DataRegister"),
    GET_REGISTER_USER("select u from Users u where u.name = :name"),
    GET_ALL_INFO("select new com.bsuir.lab.persistence.dto.AllInformDto(r.name, s.name, s.xCoordinate, s.yCoordinate,  dr.date, dr.time, dr.temperature)" +
            "from Region r " +
            "left outer join Sensor s on r.id = s.region.id " +
            "left outer join DataRegister dr on s.id = dr.sensor.id");

    private String query;

    Querys(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
