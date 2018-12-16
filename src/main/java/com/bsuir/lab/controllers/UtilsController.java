package com.bsuir.lab.controllers;

import com.bsuir.lab.dao.UtilsDao;
import com.bsuir.lab.mappers.AllInformMapper;
import com.bsuir.lab.persistence.dto.GraphicDto;
import com.bsuir.lab.services.UtilsSevice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/utils")
public class UtilsController {

    private AllInformMapper allInformMapper;
    private UtilsSevice utilsSevice;

    @Inject
    public UtilsController(AllInformMapper allInformMapper, UtilsSevice utilsSevice) {
        this.allInformMapper = allInformMapper;
        this.utilsSevice = utilsSevice;
    }

    @ResponseBody
    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object[]> g1etAll() {
        return utilsSevice.getAllInfo();
    }

    @ResponseBody
    @GetMapping(value = "/getGraphic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GraphicDto> getAllForGraphic() throws IOException {
        return utilsSevice.getAllForGraphic();
    }
}
