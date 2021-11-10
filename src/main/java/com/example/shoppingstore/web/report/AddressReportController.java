package com.example.shoppingstore.web.report;

import com.example.shoppingstore.infraestructure.report.AddressReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping()
public class AddressReportController {

    @Autowired
    private AddressReportService addressReportService;

    @RequestMapping(method = RequestMethod.GET,path = "/generate/{reportFormat}")
    public String generateReport(@PathVariable String reportFormat) throws FileNotFoundException, JRException {
        return addressReportService.exportReport(reportFormat);
    }


}
