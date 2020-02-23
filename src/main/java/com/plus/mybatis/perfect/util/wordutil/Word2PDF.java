package com.plus.mybatis.perfect.util.wordutil;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Word2PDF {

    public static void convert() throws IOException {
        long s = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("D:/孙李娅简历.docx");
        XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);
        PdfOptions pdfOptions = PdfOptions.create();
        FileOutputStream fileOutputStream = new FileOutputStream("D:/"+s+"-oi笔记.pdf");
        PdfConverter.getInstance().convert(xwpfDocument, fileOutputStream, pdfOptions);
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("共用时间(ms):" + (System.currentTimeMillis() - s)); 
    }

    public static void main(String[] args) throws IOException {
        convert();
    }
}
