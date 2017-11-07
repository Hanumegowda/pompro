package qaFramework.UserDefinedFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadAndWriteFromJson {

	StringBuilder builder = new StringBuilder();
	
	public String getFilePath(String FullPath)throws Exception{
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty(FullPath);
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		return FILE_PATH;
	}
	
	
	@SuppressWarnings("unchecked")
	public void writeToJson(String filePath,HashMap<String,String> map)throws Exception{
		String strFilePath = getFilePath(filePath);
		JSONObject jObject = new JSONObject();

	    jObject.putAll(map);
		try{
			 FileWriter fstream = new FileWriter(strFilePath,true);
	         BufferedWriter fbw = new BufferedWriter(fstream);
	         fbw.write(JSONObject.toJSONString(map));
	         fbw.newLine();
	         fbw.flush();
	         fbw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	


	public String readFromJason(String filePath, String key)
			throws Exception {
		String strFilePath = getFilePath(filePath);
		
		String keyValue="";
	    JSONObject jObject = null;
	    JSONParser parser = new JSONParser();
	    
		try {
			FileReader fstream = new FileReader(strFilePath);
			BufferedReader fbr=new BufferedReader(fstream);
			
			jObject=(JSONObject) parser.parse(fbr);
			
			JSONObject jsonObject = (JSONObject) jObject;
			keyValue = (String) jsonObject.get(key);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return keyValue;
	}
}