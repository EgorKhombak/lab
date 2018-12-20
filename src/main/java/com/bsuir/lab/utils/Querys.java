package com.bsuir.lab.utils;

public enum Querys {

    GET_ALL_REGIONS("from Region"),

    GET_ALL_SENSORS("from Sensor"),

    GET_ALL_DATA_REGISTERS("from DataRegister"),

    GET_REGISTER_USER_BY_NAME("select u from Users u where u.name = :name"),

    GET_ALL_INFO("select new com.bsuir.lab.persistence.dto.AllInformDto(r.name, s.name, s.xCoordinate, s.yCoordinate,  dr.date, dr.time, dr.temperature)" +
            "from Region r " +
            "left outer join Sensor s on r.id = s.region.id " +
            "left outer join DataRegister dr on s.id = dr.sensor.id"),

    GET_GRAPHIC_DATES_BY_REGION_ID("select new com.bsuir.lab.persistence.dto.GraphicDatesDto(dr.date, cast(round(avg(temperature)*1000000/100000) as double)/10)" +
            "from DataRegister dr " +
            "where dr.sensor.region.id = :regionId " +
            "group by dr.date"),

    GET_REGION_BY_NAME("select r from Region r where r.name = :name"),

    GET_SENSOR_BY_NAME("select s from Sensor s where s.name = :name");

    private String query;

    Querys(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
