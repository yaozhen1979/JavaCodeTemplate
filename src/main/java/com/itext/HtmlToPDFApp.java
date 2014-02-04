package com.itext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPDFApp {
    public static void main(String... args) throws DocumentException,
            IOException, URISyntaxException {
        
        // test file exist ???
        URL resourceURL = HtmlToPDFApp.class.getClass().getResource("/com/itext/index.html");
        File htmlFile = new File(resourceURL.toURI());
        System.out.println("htmlFile exist:" + htmlFile.exists());
        //
        File currDir = new File("");
        System.out.println("current dir:" + currDir.getAbsolutePath());
        System.out.println(Paths.get("").toAbsolutePath().toString());
        
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("build/com/itext/html_to_pdf.pdf"));
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