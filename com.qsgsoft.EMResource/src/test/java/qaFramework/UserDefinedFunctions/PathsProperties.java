package qaFramework.UserDefinedFunctions;

import java.io.InputStream;
import java.util.Properties;

public class PathsProperties {

	/****************************************
	 Function to read the excel path
	*****************************************/
	public Properties Read_FilePath() throws Exception {
		Properties autoitProps = new Properties();
		InputStream is = this.getClass().getResourceAsStream(
				System.getProperty("path.file",
						"/PropertiesFiles/path.properties"));
		autoitProps.load(is);
		return autoitProps;
	}

	/**********************************
	 Function to read the auto it path
	**********************************/
	public Properties ReadAutoit_FilePath() throws Exception {
		Properties autoitProps = new Properties();
		InputStream is = this.getClass().getResourceAsStream(
				System.getProperty("autoit.file",
						"/PropertiesFiles/autoItPath.properties"));
		autoitProps.load(is);
		return autoitProps;
	}

}
