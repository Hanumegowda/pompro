package qaframework.lib.UserDefinedFunctions;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This code get the process list which are currently running(shows in your task
 * manager) in your system and stored at the file named as "process.txt"
 * Remarks: The file is stored at where this java file is available. Cache the
 * file path which you need
 */
public class GetProcessList {
	
	public String GetProcessName() throws Exception {
		Process p;
		Runtime runTime;
		String process = null, line = null;

		runTime = Runtime.getRuntime();
		p = runTime.exec("tasklist"); // For Windows
		InputStream inputStream = p.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		line = bufferedReader.readLine();
		process = "&";

		while (line != null) {
			line = bufferedReader.readLine();
			process += line + "&";
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();

		return process;
	}

	/* 
	 * This function is to get the process data
	 * 
	 */
	
	public String GetProcessListData() throws Exception {
		Process p;
		Runtime runTime;
		String process = null;
		System.out.println("Processes Reading is started...");
		runTime = Runtime.getRuntime();
		p = runTime.exec("tasklist"); // For Windows
		// p=r.exec("ps ux"); //For Linux
		InputStream inputStream = p.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = bufferedReader.readLine();
		process = "&";
		while (line != null) {
			line = bufferedReader.readLine();
			process += line + "&";
			System.out.println(line + "&");
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		System.out.println("Processes are read.");
		return process;
	}

	/* 
	 * This function is to process the test data
	 * 
	 */
	
	public void showProcessData() throws Exception {
		String proc = GetProcessListData();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
				new FileOutputStream("ProcessList.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		StringTokenizer st = new StringTokenizer(proc, "&");

		while (st.hasMoreTokens()) {
			bufferedWriter.write(st.nextToken()); // Write the data in file
			bufferedWriter.newLine(); // Allocate new line for next line
		}
		bufferedWriter.close();
		outputStreamWriter.close();
	}

	public static void main(String[] args) throws Exception {
		GetProcessList gpl = new GetProcessList();
		gpl.showProcessData();

	}
}
