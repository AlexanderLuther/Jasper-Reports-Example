package com.hluther.controller;

import com.hluther.entity.Advertisement;
import com.hluther.model.AdvertisementModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ReportController", urlPatterns = {"/report"})
public class ReportController extends HttpServlet {

    private final AdvertisementModel advertisementModel;

    public ReportController() {
        this.advertisementModel = new AdvertisementModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        List<Advertisement> advertisementList = advertisementModel.getAdvertisementList();
        try {
            //Imagen
            InputStream image = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("img/imagen.jpg");

            //JasperReport template
            InputStream reportTemplate = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("reports/Ejemplo1.jasper");

            //Create a JRBeanCollectionDataSource from a List
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(advertisementList);

            //Create a map of parameters to pass to the report
            Map<String , Object> params = new HashMap<>();
            params.put("type", "Tipo desde app");
            params.put("duration", "Duracion desde app");
            params.put("image", image);
            params.put("dataSource", ds);

            //Create a JasperReport object from the template
            JasperReport report = (JasperReport) JRLoader.loadObject(reportTemplate);

            //Fill the report with data and export it to a PDF file
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, ds);
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

            //Set the content type and attachment header.
            resp.setContentType("application/pdf");
            resp.addHeader("Content-Disposition", "inline; filename=ReporteAnuncios.pdf");

            //Close the output stream.
            servletOutputStream.flush();
            servletOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
