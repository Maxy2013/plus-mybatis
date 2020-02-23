package com.plus.mybatis.perfect.business.service;

import com.plus.mybatis.perfect.model.User;
import com.plus.mybatis.perfect.util.wordutil.Word2PDF;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private TestService testService;

    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);


        cell = row.createCell(1);
        cell.setCellValue("显示名");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("创建时间");
        cell.setCellStyle(style);
    }

    public String getUserExcel() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        createTitle(workbook,sheet);
        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-MM-dd hh:mm:ssL"));


        List<User> rows = testService.queryTest();

        int rowNum=1;
        for(User user:rows){
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getHost());
            row.createCell(1).setCellValue(user.getUser());
            row.createCell(2).setCellValue(user.getPassword());
            HSSFCell cell = row.createCell(3);
            cell.setCellValue(new Date());
            cell.setCellStyle(style);
            rowNum++;
        }


        String fileName = "D:/signkey/"+System.currentTimeMillis()+"导出excel例子.xls";
        buildExcelFile(fileName, workbook);
        return "成功";
    }

    //生成excel文件
    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    public String toPdf() throws IOException {
        Word2PDF.convert();
        return "555";
    }
}
