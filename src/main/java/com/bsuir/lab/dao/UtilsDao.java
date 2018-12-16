package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.dto.GraphicDto;

import java.util.List;

public interface UtilsDao {

    List<Object[]> getAllInfo();
    List<GraphicDto> getAllForGraphic();
}
