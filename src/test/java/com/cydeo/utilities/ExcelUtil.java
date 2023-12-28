package com.cydeo.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {


    private Sheet workSheet;
    private Workbook workbook;
    private String path;

    public ExcelUtil(String path, String sheetname) {

        this.path = path;

        FileInputStream ExcelFile = null;
        try {
            ExcelFile = new FileInputStream(path);
            workbook = WorkbookFactory.create(ExcelFile);
            workSheet = workbook.getSheet(sheetname);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int rowNum, int colNum){
        Cell cell;

        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

//    public String[][] getDataArray() {
//        String[][] data = new String[rowCount()][columnCount()];
//        for (int i = 0; i < columnCount(); i++) {
//            for (int j = 0; j < columnCount(); j++) {
//                String value = getCellData(i, j);
//                data[i][j] = value;
//            }
//        }
//    }
}
