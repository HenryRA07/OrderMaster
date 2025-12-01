package edu.unl.cc.ordermaster.domain;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFgenerator {
    Document document;
    FileOutputStream fos;

    Font titulo = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14);
    Font parrafo = FontFactory.getFont(FontFactory.HELVETICA, 12);

    private void Creardocumento(String nombre) throws DocumentException, FileNotFoundException {
        document = new Document(PageSize.A4,35,35,50,50);
        fos = new FileOutputStream( "D:\\\\Usuarios\\\\Franz\\\\Documentacion\\\\Comprovante"+nombre+".pdf");
        PdfWriter.getInstance(document,fos);
    }
    public void abrirDocumento(){
        document.open();
    }
    public void generar(String texto,String nombre) throws DocumentException, FileNotFoundException {
        Creardocumento(nombre);
        abrirDocumento();
        Paragraph para = new Paragraph();
        para.add(new Paragraph(texto, parrafo));
        document.add(para);
        cerrarDocumento();
    }
    public void cerrarDocumento(){
        document.close();
        System.out.println("pdf generado");
    }
}
