package qaFramework.UserDefinedFunctions;

import static org.testng.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVFunctions {


	public String verifyMonthlyAssesmentCSVData(String strFilePath, String[][] strReportData)
			throws IOException, InterruptedException {
		String strReason = "";
		try {
		
			int intCount = 0;
			String strCellValue;

			File file = new File(strFilePath);
			boolean strExists = file.exists();
			if (!strExists) {
				// It returns false if File or directory does not exist
				strReason = "The CSV report file is NOT found";
			} else {
				if (file.length() == 0) {
					strReason = "Unable to read the file";
				} else {
					String strFileName = file.getName();


					BufferedReader bufRdr = new BufferedReader(new FileReader(
							file));

					String line = null;
					int row = 0, col = 0;
					int intCount1 = 23;
					while ((line = bufRdr.readLine()) != null) {
						col = 0;
						while (line.contains(",,")) {
							line = line.replaceAll(",,", ",**,");
						}

						String strVar= "";
						StringTokenizer strToken = new StringTokenizer(line,
								",");
						while (strToken.hasMoreTokens()) {
							strCellValue = strToken.nextToken();

							if(row <8){
								assertTrue(strCellValue
										.equals(strReportData[row][col]));
							}
							else if(row ==8 && col!=0 && col<=31){
								assertTrue(strCellValue
										.equals("\""+col+"\""));
							}
							
							else if(row>=9 && col==0 && intCount1>=0){	
								if((""+intCount1).length()==1){
									 strVar = ("\"0"+intCount1+":00\"");
								}else{
									 strVar = ("\""+intCount1+":00\"");
								}
								
									assertEquals(strCellValue,strVar);
									intCount1--;
							}
							
							col++;
							intCount++;

						}
						row++;
					}

					int len=0;
					for(int i=0;i<strReportData.length;i++){
						len=len+strReportData[i].length;
					}

					if (intCount != len) {
	
						strReason = strReason
								+ "Report is NOT generated"
								+ " in CSV format with all the specified details";
					}
					// close the file

					bufRdr.close();
				}
			}
		} catch (Exception e) {
			strReason = "Failed in function ReadFromCSV" + e.toString();
		}

		return strReason;
	}
	
	
	@SuppressWarnings("null")
	public String readCSVFileData(String strFilePath, int strRowCount)
			throws Exception

	{

		String line;
		String Line = "";

		String[] strdata = null;
		int count = 1;
		String splitBy = ",";
		BufferedReader br = new BufferedReader(new FileReader(strFilePath));

		while ((line = br.readLine()) != null && count < strRowCount) {

			Line = line;

			System.out.println("line" + line);
			count++;
		}
		br.close();

		return Line;

	}
}
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		

