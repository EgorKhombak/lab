package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.dto.AllInformDto;
import com.bsuir.lab.persistence.dto.GraphicDto;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface UtilsDao {

    List<AllInformDto> getAllInfo() throws IOException, JSONException;
    List<GraphicDto> getAllForGraphic(List<String> regionNames);
}
