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

public class UsersTab implements Observer, DisplayFile {
	// Data Structure holding filtered data
	private List<String> filteredData;
	private Subject dashBoard;
	private String outPath;
	private static int dsIndex = 0;

	// constructor
	public UsersTab(Subject dashBoard, String outputPath) {
		MyLogger.getInstance().printToStdout(2,
				"DEBUG MESSAGE FROM Constructor of UsersTab");
		this.filteredData = new ArrayList<String>();
		this.dashBoard = dashBoard;
		this.outPath = outputPath;
	}

	/***
	 * Updates every observer with filter Users
	 */
	@Override
	public void update(String inputLine) {
		BufferedWriter writer = null;
		try {
			MyLogger.getInstance().printToStdout(3,
					"DEBUG MESSAGE FROM update method of UsersTab");
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

			inputLine = inputLine.replaceAll("Users:", "").trim();
			String[] userData = inputLine.split("-");

			tag = "";
			tag = tag.trim();

			for (int i = 0; i < userData.length; i++) {
				String[] subUserData = userData[i].split(":");
				tag = "User: " + subUserData[0] + "  ";
				tag += "Status: " + subUserData[1]
						+ System.getProperty("line.separator");

				this.filteredData.add(tag);
			}

			String fileContent = display(flagBegin, flagEnd);
			fProcessor.writeToFile(fileContent + System.getProperty("line.separator"));
		} catch (FileNotFoundException e) {
			MyLogger.getInstance()
					.printToStdout(
							0,
							"DEBUG MESSAGE FROM FileNotFound catch block of Update method in Users Observer");
			System.err
					.println("Exception as file not found in update of UsersTab");
			System.exit(1);
		} catch (IOException e) {
			MyLogger.getInstance()
					.printToStdout(0,
							"DEBUG MESSAGE FROM IO catch block of Update method in Users Observer");
			System.err
					.println("Exception due Stream Reader I/O operation in update of UsersTab");
			System.exit(1);
		}

	}

	/***
	 * Displays the filtered data
	 */
	@Override
	public String display(int beginFlag, int endFlag) {
		MyLogger.getInstance().printToStdout(1,
				"DEBUG MESSAGE FROM display method of UsersTab");
		String tag = "";
		if (beginFlag == 1) {
			tag = "---TAB(s) BEGIN---" + System.getProperty("line.separator");
		}
		tag += "---USERS---" + System.getProperty("line.separator");
		for (int i = dsIndex; i < this.filteredData.size(); i++)
			tag += this.filteredData.get(i);
		dsIndex = this.filteredData.size();
		if (endFlag == 1) {
			tag += System.getProperty("line.separator") + "---TAB(s) END---";
		}
		return tag;
	}

	/***
	 * To unregister this observer from subject
	 */
	public void unRegister() {
		MyLogger.getInstance().printToStdout(3,
				"DEBUG MESSAGE FROM unregister method of Users Observer");
		this.dashBoard.removeObserver(this);
	}

	// Overriding toString method in UsersTab class
	public String toString() {
		return "\nOverriding toString in UsersTab Class";
	}

}
