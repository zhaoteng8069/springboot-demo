package com.example.springbootdemo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * @className ExcelUtils
 * @Description TODO
 * @Author zhaoteng
 * @Date 2019/7/23 16:58
 * @Version 1.0
 **/
public class ExcelUtils {

    /**
     * 导入Excel
     * @param filePath 文件存储路径
     * @param sheetIndex sheet下标 从0开始
     * @throws Exception
     * @desc 行的起始下标根据实际情况调整
     */
    public static void importExcel(String filePath , int sheetIndex) throws Exception {

        FileInputStream in = null;
        XSSFWorkbook workbook = null;
        try {
            in = new FileInputStream(new File(filePath));
            // 加载xlsx文档
            workbook = new XSSFWorkbook(in);
            int totalSheets = workbook.getNumberOfSheets();
            if (sheetIndex >= totalSheets) {
                return;
            }
            // 加载sheet
            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            // 解析sheet
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                int lastCellNum = row.getLastCellNum();
                for (int l = 0; l < lastCellNum; l++) {
                    XSSFCell cell = row.getCell(l);
                    System.out.println(String.format("%d行%d列数据为%s", i + 1, l, getCell(cell)));
                }
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 获取excel单元格数据
     * @param cell excel单元格
     * @return
     */
    private static String getCell(XSSFCell cell) {
        if (cell == null) {
            return "";
        }
        String value;
        switch (cell.getCellType()) {
            // 数字
            case HSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                } else {
                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
                }
                break;
            // 字符串
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            // 布尔值
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            // 公式
            case HSSFCell.CELL_TYPE_FORMULA:
                value = cell.getCellFormula();
                break;
            // 空值
            case HSSFCell.CELL_TYPE_BLANK:
                value = "";
                break;
            // 故障
            case HSSFCell.CELL_TYPE_ERROR:
                value = "非法字符";
                break;
            default:
                value = "未知类型";
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        //
        long start = System.currentTimeMillis();
        String filePath = "C:\\Users\\sonli\\Desktop\\xlsx\\order-2019-2.xlsx";
        importExcel(filePath, 0);
        long end = System.currentTimeMillis();
        System.out.println(String.format("####解析结束，总共耗时%dms！", end - start));
    }

}
