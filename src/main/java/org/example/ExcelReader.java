package org.example;

import org.apache.poi.ss.usermodel.*;
import  org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void readExcelFile(String args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("D:\\projectss\\deleteHarborTags\\src\\main\\java\\org\\example\\harbortags.xlsx");
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            // Just get tag
            int tagsIdColumnIndex = 0;
            HttpDelete httpDelete = new HttpDelete();
            for (Row row : sheet) {
                tagsIdColumnIndex = findColumnIndex(row, "tagsid");
                System.out.println(tagsIdColumnIndex);
                break;
            }
            for (Row row: sheet){
                Cell tagsIdCell = row.getCell(tagsIdColumnIndex);
                if(tagsIdCell.getCellType()==Cell.CELL_TYPE_STRING) {
//                    String cellValue = tagsIdCell.getStringCellValue();
//                    System.out.println(cellValue);
//                    httpDelete.sendDeleteRequest(cellValue);
                    continue;
                }
                if(tagsIdCell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
                    String cellValue = Integer.toString((int) tagsIdCell.getNumericCellValue());
                    System.out.println(cellValue);
                    httpDelete.sendDeleteRequest(cellValue);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findColumnIndex(Row headerRow, String ColumnName) {
        for (Cell cell : headerRow) {
            if(cell.getCellType()==Cell.CELL_TYPE_STRING){
                if(cell.getStringCellValue().equalsIgnoreCase(ColumnName)){
                    return cell.getColumnIndex();
                }
            }
            if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
                if(Integer.toString((int) cell.getNumericCellValue()).equalsIgnoreCase(ColumnName)){
                    return cell.getColumnIndex();
                }
            }
        }
        return -1;
    }




}
