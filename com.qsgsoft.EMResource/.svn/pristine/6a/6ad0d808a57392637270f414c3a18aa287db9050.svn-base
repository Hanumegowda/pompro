package qaFramework.UserDefinedFunctions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import qaFramework.UserDefinedFunctions.PathsProperties;

public class ReadAndWriteFromXMLFile {

	public void write(String strFilePath,
			String[] StrNewValue, String[] strNode)
			throws Exception {
		String strFileName = this.getFilePath(strFilePath);
		File file = new File(strFileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setCoalescing(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);

//		ReadAndWriteFromXMLFile obj = new ReadAndWriteFromXMLFile();
		for (int i = 0; i < strNode.length; i++) {
			this.changeValue(doc, StrNewValue[i], strNode[i]);
		}
		this.save(file, doc);
	}
	
	public void write(String strFilePath,
			 String strNewValue, String strNode)
			throws Exception {
		String strFileName = this.getFilePath(strFilePath);
		File file = new File(strFileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setCoalescing(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);

		this.changeValue(doc, strNewValue, strNode);
		this.save(file, doc);
	}

	public String read(String tagName, String filePath) throws Exception {
		String tagValue = "";
		try {
		String fXmlFile = getFilePath(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		tagValue = doc.getElementsByTagName(tagName).item(0)
				.getTextContent();
		} 
		catch (Exception e) {
			
		}
		return tagValue;
	}

	public void changeValue(Document doc, String NewValue, String strNode)
			throws Exception {
		Element root = doc.getDocumentElement();
		NodeList childNodes = root.getElementsByTagName(strNode);

		if(childNodes.getLength() == 0) {
			Element element = doc.getDocumentElement();
			Element node = doc.createElement(strNode);
			Text text = doc.createTextNode(NewValue);
			node.appendChild(text);
			element.appendChild(node);
		}
		
		for (int i = 0; i < childNodes.getLength(); i++) {
			NodeList subChildNodes = childNodes.item(i).getChildNodes();

			for (int j = 0; j < subChildNodes.getLength(); j++) {
				subChildNodes.item(j).setTextContent(NewValue);
			}
		}
	}

	public void save(File file, Document doc) throws Exception {
		TransformerFactory factory1 = TransformerFactory.newInstance();
		Transformer transformer = factory1.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String s = writer.toString();
		System.out.println(s);

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		bufferedWriter.write(s);
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	public String getFilePath(String strPath) throws Exception {
		PathsProperties objAP = new PathsProperties();
		Properties pathProps = objAP.Read_FilePath();
		String FILE_PATH = pathProps.getProperty(strPath);
		String[] fileName = FILE_PATH.split("/");
		File file = new File(fileName[fileName.length - 1]);
		String path = file.getAbsolutePath();
		FILE_PATH = path.replaceAll(fileName[fileName.length - 1], FILE_PATH);
		return FILE_PATH;
	}
}
