package com.itext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class BootstrapLayoutToPDF {
    public static void main(String... args) throws DocumentException,
            IOException, URISyntaxException {

        // test file exist ???
        URL resourceURL = BootstrapLayoutToPDF.class.getClass().getResource(
                "/com/bootstrap/layout.html");
        File htmlFile = new File(resourceURL.toURI());
        System.out.println("htmlFile exist:" + htmlFile.exists());
        
        // step 1
        Document document = new Document();
        
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("build/com/itext/bootstrap_to_pdf.pdf"));
        
        // step 3
        document.open();
        
        // step 4
        System.out.println("Creating PDF file ...");
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new FileInputStream(htmlFile));
        
        // step 5
        document.close();

        System.out.println("PDF Created!");
    }
}
