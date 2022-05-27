package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	protected ConfigUtils readProp = new ConfigUtils();

	public static void main(String[] args) throws Exception {
		ExcelUtil obj = new ExcelUtil();
		for (int i = 0; i <= obj.returnSheet().getLastRowNum(); i++) {
			System.out.println(obj.readExcel(i, 0) + " " + obj.readExcel(i, 1));
			Thread.sleep(101);
		}
	}

	public String readExcel(int row, int column) throws Exception {
		XSSFSheet sheet = returnSheet();
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public XSSFSheet returnSheet() throws Exception {
		File excelPath = new File(readProp.getProp("excelPath"));
		FileInputStream stream = new FileInputStream(excelPath);
		XSSFWorkbook wb = new XSSFWorkbook(stream);
		XSSFSheet sheet = wb.getSheetAt(0);
		return sheet;
	}

}
