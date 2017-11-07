package qaframework.lib.userDefinedFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileFormatConverter {
	@Test
	
	public void convertXmlToZip(String file1, String file2,String file3) throws Exception {
		byte[] buff = new byte[1024];
  /*System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\BackUpFiles\\1464950215858.xml");
  String str = System.getProperty("user.dir") + "\\src\\test\\resources\\BackUpFiles\\1464950215858.xml";
  String str1 = System.getProperty("user.dir") + "\\src\\test\\resources\\BackUpFiles\\1464950215858";*/
  //String str2 = file2+".zip";
  
		
		FileOutputStream fos = new FileOutputStream(file2);
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry ze = new ZipEntry(file3);
		zos.putNextEntry(ze);
		FileInputStream fis = new FileInputStream(file1);
		
		int len;
		while((len=fis.read(buff))>0){
			zos.write(buff, 0, len);
		}
		fis.close();
		zos.closeEntry();
		zos.close();
		
		System.out.println("done");
		
		
	}
	
	public void writetocsv(String filepath,String loc,String loc1,String loc2,String loc3,String loc4) throws Exception{
		File file = new File(filepath);
		if(!file.exists()){
			System.out.println("no file found");
		}
		else{
			
			System.out.println("file is present");
		FileWriter f = new FileWriter(filepath);
		f.append(loc);
		f.append(loc1);
		f.append(loc2);
		f.append(loc3);
		f.append(loc4);
		f.close();
			}
		Thread.sleep(5000);

}
	
	public void writeToCSVFile(List<String[]> str, String filepath)
			throws Exception {
		CSVReader cr = new CSVReader(new FileReader(filepath));
		List<String[]> li = new ArrayList<String[]>();
		List<String[]> ac = cr.readAll();
		for (int i = 0; i < ac.size(); i++) {
			String[] strfirstrow = ac.get(i);
			li.add(strfirstrow);
		}
		for (int i = 0; i < str.size(); i++) {
			li.add(str.get(i));
		}
		System.out.println(li.size() + " this is the final size");
		CSVWriter cw = new CSVWriter(new FileWriter(filepath));
		cw.writeAll(li);
		cw.flush();
		cw.close();
		cr.close();

	}
	
	public StringBuilder getTextFromTextFile(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		br.close();
		return sb;

	}
}
