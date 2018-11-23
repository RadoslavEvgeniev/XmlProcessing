package cardealer.web.controllers;

import cardealer.domain.dtos.CarExportRootDto;
import cardealer.service.CarService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;

@Controller
public class ExportController {

    private final CarService carService;
    private final XmlParser xmlParser;

    @Autowired
    public ExportController(CarService carService, XmlParser xmlParser) {
        this.carService = carService;
        this.xmlParser = xmlParser;
    }

    public String exportCars() throws JAXBException {
        CarExportRootDto carExportRootDto = this.carService.exportCars();

        this.xmlParser.exportToXml(carExportRootDto, CarExportRootDto.class, "C:\\Users\\Guest Lector\\Desktop\\CarDealer\\src\\main\\resources\\files\\output\\cars-and-parts.xml");
        return null;
    }
}
