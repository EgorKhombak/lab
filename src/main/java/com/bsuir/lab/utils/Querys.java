package com.bsuir.lab.utils;

public enum Querys {

    GET_ALL_REGIONS("from Region"),
    GET_ALL_SENSORS("from Sensor"),
    GET_ALL_DATA_REGISTERS("from DataRegister"),
    GET_REGISTER_USER("select u from Users u where u.name = :name");

    private String query;

    Querys(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
