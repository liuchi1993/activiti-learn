package cn.liuc.activitidemo.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Date: 2019/12/3 21:03
 */
public class ExcelUtil {

    /**
     * 使用 alibaba 的 EasyExcel 来生成 Excel 文件
     * 需要实体类使用注解
     * @param outputStream
     * @param sheetName
     * @param clazz
     * @param list
     */
    public static void exportExcel(OutputStream outputStream,
                                   String sheetName,
                                   Class clazz,
                                   List list) {
        EasyExcel.write(outputStream,
                        clazz)
                .autoCloseStream(Boolean.FALSE)
                .sheet(sheetName)
                .doWrite(list);
    }

    /**
     * 使用 Apache 的 POI 生成 Excel
     * @param outputStream
     * @param sheetName
     * @param titles
     * @param data
     */
    public static void exportExcel(OutputStream outputStream,
                                   String sheetName,
                                   String[] titles,
                                   List<List<String>> data) {
        Workbook wb = new XSSFWorkbook();
        String safeName = WorkbookUtil.createSafeSheetName(sheetName);
        Sheet sheet = wb.createSheet(!"".equals(safeName.trim()) ? safeName : "Sheet1");

        Row row = sheet.createRow(0);
        // 设置表头
        for (int i = 0; i < titles.length; i++) {
            row.createCell(i).setCellValue(titles[i]);
        }

        // 设置表格数据
        List<String> list;
        for (int i = 0; i < data.size(); i++) {
            row = sheet.createRow(i + 1);
            list = data.get(i);
            for (int j = 0; j < list.size(); j++) {
                row.createCell(j).setCellValue(list.get(j));
            }
        }

        for (int i = 0; i < titles.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try {
            wb.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
