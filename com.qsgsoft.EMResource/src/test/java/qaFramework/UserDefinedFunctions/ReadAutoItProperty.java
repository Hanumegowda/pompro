package qaFramework.UserDefinedFunctions;

import java.io.File;
import java.util.Properties;

public class ReadAutoItProperty {

	public static String readDataFromAutoItPath(String strFileName)
			throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.ReadAutoit_FilePath();
		String FILE_PATH = pathProps.getProperty(strFileName);
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		return FILE_PATH;
	}
	
	public static String readDataFromPathProperties(String strFileName)
			throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty(strFileName);
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[0]);
		String path = file.getAbsolutePath();
		return path;
	}
	
}