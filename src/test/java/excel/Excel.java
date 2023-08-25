package excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class Excel {

    @Test
    public void autotest() throws IOException, InterruptedException {
        createXls(); //Создаем xls файл
        dataFill();
        dataRead();
        dataAssert();
        deleteXls(); //Удаляем xls файл
    }

    public void createXls() throws IOException {   //Создаем xls файл
        Workbook book = new HSSFWorkbook();
        Sheet sheet = ((HSSFWorkbook) book).createSheet("New sheet");
        ((HSSFWorkbook) book).write(new FileOutputStream("./excel_tests.xls"));
        ((HSSFWorkbook) book).close();
    }

    public void dataFill() throws IOException {
        FileInputStream file = new FileInputStream(new File("./excel_tests.xls"));
        HSSFWorkbook book = new HSSFWorkbook(file);
        HSSFSheet sheet = book.getSheetAt(0);
        int x = 0;
        Row row = sheet.createRow(x);
        for (x = 0; x < 10; x++) {
            Cell name = row.createCell(x);
            name.setCellValue(x + 1);
        }
        ((HSSFWorkbook) book).write(new FileOutputStream("./excel_tests.xls"));
        ((HSSFWorkbook) book).close();
    }

    public ArrayList<Integer> dataRead() throws IOException {
        Double result;
        ArrayList<Integer> arrExcel = new ArrayList();
        int i = 0;
        HSSFSheet sheet = openExcel("./excel_tests.xls");
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
        Iterator<Cell> cells = row.iterator();
        while (cells.hasNext()) {
            Cell cell = cells.next();
            result = cell.getNumericCellValue();
            Integer x = result.intValue();
            arrExcel.add(i, x);
            i++;
        }
        return arrExcel;
    }

    public void dataAssert() throws IOException {
        ArrayList<Integer> data_xls = dataRead();
        ArrayList<Integer> array = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(data_xls, array);
        System.out.println(array);
        System.out.println(data_xls);
    }


    public HSSFSheet openExcel(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    public void deleteXls() throws InterruptedException {  //Удаляем xls файл
        File fileToDelete = new File("./excel_tests.xls");
        boolean success = fileToDelete.delete();
        assertTrue(success);
        System.out.println(success);
    }
}
