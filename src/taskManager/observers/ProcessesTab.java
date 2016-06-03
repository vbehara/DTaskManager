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

public class ProcessesTab implements Observer, DisplayFile {

	private Subject dashBoard;
	private List<String> filteredData;
	private String outPath = "";

	// Constructor
	public ProcessesTab(Subject dashBoard, String outFilePath) {
		MyLogger.getInstance().printToStdout(2, "DEBUG MESSAGE FROM Constructor of ProcessesTab");
		this.dashBoard = dashBoard;
		this.outPath = outFilePath;
		this.filteredData = new ArrayList<String>();
	}

	/***
	 * Updates every observer with filter Processes
	 */
	@Override
	public void update(String inputLine) {
		BufferedWriter writer = null;
		try {
			MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM update method of ProcessesTab");
			int flagBegin = 0, flagEnd = 0;
			writer = new BufferedWriter(new FileWriter(this.outPath, true));

			FileProcessor fProcessor = new FileProcessor(writer, this.outPath);
			if (inputLine.startsWith("Begin")) {
				flagBegin = 1;
				inputLine = inputLine.replaceAll("Begin", "").trim();
			}

			if (inputLine.endsWith("End")) {
				flagEnd = 1;
				inputLine = inputLine.replaceAll("End", "").trim();
			}

			inputLine = inputLine.replaceAll("Processes:", "").trim();
			String[] processesData = inputLine.split("-");

			String formattedData = "";
			for (int i = 0; i < processesData.length; i++) {
				String[] subProcessData = processesData[i].split(":");
				formattedData = formattedData
						+ String.format("%5s", subProcessData[0]) + " "
						+ String.format("%-15s", subProcessData[1]) + " "
						+ String.format("%-8s", subProcessData[2]) + " "
						+ String.format("%4s", subProcessData[3]) + " "
						+ String.format("%4s", subProcessData[4])
						+ System.getProperty("line.separator");

				this.filteredData.add(formattedData);
			}

			String fileContent = display(flagBegin, flagEnd);

			fProcessor.writeToFile(fileContent);
		} catch (FileNotFoundException e) {
			MyLogger.getInstance().printToStdout(0,"DEBUG MESSAGE FROM FileNotFound catch block of Update method in Processes Observer");
			System.err.println("Exception as file not found in update of processesTab");
			System.exit(1);
		} catch (IOException e) {
			MyLogger.getInstance().printToStdout(0,"DEBUG MESSAGE FROM IO catch block of Update method in Processes Observer");
			System.err.println("Exception due Stream Reader I/O operation in update of processesTab");
			System.exit(1);
		}

	}

	/***
	 * Displays the filtered data
	 */
	@Override
	public String display(int beginFlag, int endFlag) {
		MyLogger.getInstance().printToStdout(1, "DEBUG MESSAGE FROM display method of ProcessesTab");
		String formattedData = "";
		if (beginFlag == 1) {
			formattedData = "---TAB(s) BEGIN---"
					+ System.getProperty("line.separator");
		}
		formattedData += "---PROCESSES---"
				+ System.getProperty("line.separator");

		formattedData += String.format("%5s", "PID") + " "
				+ String.format("%-15s", "COMMAND") + " "
				+ String.format("%-8s", "USER") + " "
				+ String.format("%4s", "%CPU") + " "
				+ String.format("%4s", "%MEM")
				+ System.getProperty("line.separator");

		formattedData += this.filteredData.get(this.filteredData.size() - 1);

		if (endFlag == 1) {
			formattedData += System.getProperty("line.separator")
					+ "---TAB(s) END---" + System.getProperty("line.separator");
		}
		return formattedData;
	}

	/***
	 * To unregister from subject
	 */
	public void unRegister() {
		MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM unregister method of Processes Observer");
		this.dashBoard.removeObserver(this);
	}

	// Overriding toString method in ProcessesTab class
	public String toString() {
		return "\nOverriding toString in ProcessesTab Class";
	}

}
