package taskManager.observers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class PerformanceTab implements Observer, DisplayFile {

	private Subject dashBoard;
	private List<String> filteredData;
	private String outPath = null;

	// Constructor
	public PerformanceTab(Subject dashBoard, String outFilePath) {
		MyLogger.getInstance().printToStdout(2,
				"DEBUG MESSAGE FROM Constructor of PerformanceTab");
		this.outPath = outFilePath;
		this.dashBoard = dashBoard;
		this.filteredData = new ArrayList<String>();
	}

	/***
	 * Updates every observer with filter Performance
	 */
	@Override
	public void update(String inputLine) {
		MyLogger.getInstance().printToStdout(3,
				"DEBUG MESSAGE FROM update method of Performance Observer");
		BufferedWriter writer = null;
		try {
			int flagBegin = 0, flagEnd = 0;
			

			writer = new BufferedWriter(new FileWriter(this.outPath, true));

			FileProcessor fProcessor = new FileProcessor(writer, this.outPath);
			String tag = "";

			if (inputLine.startsWith("Begin")) {
				flagBegin = 1;
				inputLine = inputLine.replaceAll("Begin", "").trim();
			}

			if (inputLine.endsWith("End")) {
				flagEnd = 1;
				inputLine = inputLine.replaceAll("End", "").trim();
			}

			inputLine = inputLine.replaceAll("Performance:", "").trim();
			String[] performanceData = inputLine.split(":");

			tag = "";
			tag = tag.trim();
			tag = "Memory Total: " + performanceData[0] + "  ";
			tag += "Memory Used: " + performanceData[1] + "  ";
			tag += "Memory  Free: " + performanceData[2] + "  ";
			tag += "Memory  Cached: " + performanceData[3]
					+ System.getProperty("line.separator");
			tag += "CPU Idle: " + performanceData[4] + "  ";
			tag += "CPU User Level: " + performanceData[5] + "  ";
			tag += "CPU System Level: " + performanceData[6]
					+ System.getProperty("line.separator");
			this.filteredData.add(tag);
			String fileContent = display(flagBegin, flagEnd);

			fProcessor.writeToFile(fileContent);
		}

		catch (FileNotFoundException e) {
			MyLogger.getInstance().printToStdout(0,"DEBUG MESSAGE FROM FileNotFound catch block of Update method in Performance Observer");
			System.err.println("Exception as file not found in update of performanceTab");
			System.exit(1);
		} catch (IOException e) {
			MyLogger.getInstance().printToStdout(0,"DEBUG MESSAGE FROM IO catch block of Update method in Performance Observer");
			System.err.println("Exception due Stream Reader I/O operation in update of performanceTab");
			System.exit(1);
		}

	}

	/***
	 * Displays the filtered data
	 */
	@Override
	public String display(int beginFlag, int endFlag) {
		MyLogger.getInstance().printToStdout(1,
				"DEBUG MESSAGE FROM display method of PerformanceTab");
		String tag = "";
		if (beginFlag == 1) {
			tag = "---TAB(s) BEGIN---" + System.getProperty("line.separator");
		}
		tag += "---PERFORMANCE---" + System.getProperty("line.separator");
		tag += this.filteredData.get(this.filteredData.size() - 1)
				+ System.getProperty("line.separator");

		if (endFlag == 1) {
			tag += "---TAB(s) END---"
					+ System.getProperty("line.separator");
		}
		return tag;
	}

	/***
	 * To unregister this observer from subject
	 */
	public void unRegister() {
		MyLogger.getInstance().printToStdout(3,
				"DEBUG MESSAGE FROM unregister method of Performance Observer");
		this.dashBoard.removeObserver(this);
	}

	// Overriding toString method in PerformanceTab class
	public String toString() {
		return "\nOverriding toString in PerformanceTab Class";
	}

}
