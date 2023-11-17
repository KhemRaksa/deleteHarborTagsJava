package org.example;
import org.example.ExcelReader;
import org.example.HttpDelete;

public class Main {
    public static void main(String[] args) {
        ExcelReader excelReader = new ExcelReader();
        excelReader.readExcelFile("D:\\projectss\\deleteHarborTags\\src\\main\\java\\org\\example\\harbortags.xlsx");
    }
}