package qaFramework.UserDefinedFunctions;

import java.io.File;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableWorkbook;

public class ReadData {
	@SuppressWarnings("unused")
	private static WritableCellFormat courier;
	/**
	 * This function is used to read data from the Excel file
	 * 
	 * @throws Exception
	 */
	public static String readDataFromUserDetails(String SheetName, int intRow, int intColumn)
			throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String FILE_PATH = pathProps.getProperty("UserDetails_path");
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		Sheet ws = null;

		// Read the existing file
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		ws = wb.getSheet(SheetName);

		// Read content of the cell
		String strCellContent = ws.getCell(intColumn - 1, intRow - 1)
				.getContents();
		wb.close();

		return strCellContent;
	}

	/**************************************************************************************
	 * Description: Function to read the data from the excel with some specified sheet name
	 **************************************************************************************/
	
	public static String readDataFromTestData(String SheetName, int intRow,
			int intColumn) throws Exception {

		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();

		String FILE_PATH = pathProps.getProperty("TestDataPath");
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		Sheet ws = null;
		
		Workbook wb = Workbook.getWorkbook(new File(FILE_PATH));
		ws = wb.getSheet(SheetName);

		// Read content of the cell
		String strCellContent = ws.getCell(intColumn - 1, intRow - 1)
				.getContents();
		wb.close();

		return strCellContent;
	}
	
	/**************************************************************************************
	 * Description: Function to write the data from the excel with some specified sheet name
	 **************************************************************************************/
	
	public void WriteTestDatatoSpecifiedCell(String strTestData,
			String strFilePath, String strSheetName, int intRow, int intCol)
			throws Exception {

		// Read the existing file
		String[] fileName = strFilePath.split("/");
		File file = new File(fileName[fileName.length-1]);
		String path = file.getAbsolutePath();
		strFilePath = path.replaceAll(fileName[fileName.length-1], strFilePath);
		
		Workbook wb = Workbook.getWorkbook(new File(strFilePath));

		// Create a writable workbook with the same name using the workbook
		// object that has been read from file
		WritableWorkbook wwb = Workbook.createWorkbook(new File(strFilePath),
				wb);

		WritableCellFormat wcf = new WritableCellFormat();
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
		wcf.setWrap(true);

		WritableFont courier10pt = new WritableFont(WritableFont.COURIER, 10);
		// Define the cell format
		courier = new WritableCellFormat(courier10pt);
		wcf.setFont(courier10pt);

		Label label1 = new Label(intCol - 1, intRow - 1, strTestData, wcf);
		wwb.getSheet(strSheetName).addCell(label1);

		// Write the data
		wwb.write();

		wwb.close();
	}
}
