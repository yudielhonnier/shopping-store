package com.example.shoppingstore.infraestructure.report;

import com.example.shoppingstore.domain.vendor.Address;
import com.example.shoppingstore.domain.vendor.VendorService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressReportService {

    @Autowired
    private VendorService vendorService;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        List<Address> addresses=vendorService.getAddress();
        System.out.println("addressList size==========="+addresses.size());
        File file = ResourceUtils.getFile("classpath:reports\\address.jrxml");
        System.out.println("absolutepath ==========="+file.getAbsolutePath());

        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(addresses);
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("createBy","Yudiel");
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"D:\\MY PROYECTS BACKEND\\Reportes\\address.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\MY PROYECTS BACKEND\\Reportes\\address.pdf");

        }

        return "report generated successful";
    }



}
