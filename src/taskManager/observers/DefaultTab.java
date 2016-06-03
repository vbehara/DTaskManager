package taskManager.observers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import taskManager.display.DisplayFile;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class DefaultTab implements Observer, DisplayFile {

	private Subject dashBoard;
	private String outPath;

	//constructor
	public DefaultTab(Subject dashBoard, String outputPath) {
		MyLogger.getInstance().printToStdout(2, "DEBUG MESSAGE FROM Constructor of DefaultTab");
		this.dashBoard = dashBoard;
		this.outPath = outputPath;
	}

	/***
	 * Updates this observer
	 */
	@Override
	public void update(String inputLine) {
		BufferedWriter writer = null;
		try {
			MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM update of Default observer");
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
			String content = display(flagBegin, flagEnd);
			fProcessor.writeToFile(content);
		} catch (FileNotFoundException e) {
			MyLogger.getInstance().printToStdout(0, "DEBUG MESSAGE FROM FileNotFound catch block of Update method in Default Observer");
			System.err.println("Exception as file not found in catch block of Update method in Default Observer");
			System.exit(1);
		} catch (IOException e) {
			MyLogger.getInstance().printToStdout(0, "DEBUG MESSAGE FROM IO catch block of Update method in Default Observer");
			System.err.println("Exception due Stream Reader I/O operation in catch block of Update method in Default Observer");
			System.exit(1);
		}
	}

	/***
	 * 
	 */
	@Override
	public String display(int beginFlag, int endFlag) {
		MyLogger.getInstance().printToStdout(1, "DEBUG MESSAGE FROM display method of DefaultTab");
		String tag = "";
		if (beginFlag == 1) {
			tag = "---TAB(s) BEGIN---" + System.getProperty("line.separator");
		}

		if (endFlag == 1) {
			tag += "---TAB(s) END---" + System.getProperty("line.separator");
		}
		return tag;
	}

	/***
	 * To unregister this observer from subject
	 */
	public void unRegister() {
		MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM unregister Default observer");
		this.dashBoard.removeObserver(this);
	}

	// Overriding toString method in DefaultTab class
	public String toString() {
		return "\nOverriding toString in DefaultTab Class";
	}

}
