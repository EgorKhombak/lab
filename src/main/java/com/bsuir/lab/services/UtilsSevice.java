package com.bsuir.lab.services;

import com.bsuir.lab.persistence.dto.GraphicDto;

import java.io.IOException;
import java.util.List;

public interface UtilsSevice {

    List<Object[]> getAllInfo();

    List<GraphicDto> getAllForGraphic() throws IOException;
}
