package taskManager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor {
	private BufferedReader reader;
	private BufferedWriter writer;
	private String fileName;

	// constructor takes input read file
	public FileProcessor(BufferedReader reader, String readFileName) {
		MyLogger.getInstance().printToStdout(2, "DEBUG MESSAGE FROM Constructor of FileProcessor with Buffered reader as param");
		this.fileName = readFileName;
		this.reader = reader;
	}

	//constructor taking output fileName
	public FileProcessor(BufferedWriter writer, String outFile) {
		MyLogger.getInstance().printToStdout(2, "DEBUG MESSAGE FROM Constructor of FileProcessor with Buffered writer as param");
		this.fileName = outFile;
		this.writer = writer;
	}

	/***
	 * Reads data from the file
	 * 
	 * @return only single of file
	 */
	public String readFromFile() {
		String inputLineFromFile = "";
		try {
			inputLineFromFile = this.reader.readLine(); // buffer reader use
		} catch (FileNotFoundException e) {
			System.err.println("Exception as file not found");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Exception due Stream Reader I/O operation ");
			System.exit(1);
		}
		return inputLineFromFile;
	}

	/***
	 * Write particular line to a file
	 * 
	 * @param writeThisLine
	 * @param outPath
	 */
	public void writeToFile(String writeThisLine) {
		try {
			File file = new File(this.fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			file.setWritable(true);
			// this.writer = new BufferedWriter(new FileWriter(file, true));
			this.writer.append(writeThisLine); // buffer writer use
			this.writer.flush();
		} catch (FileNotFoundException e) {
			System.err.println("Exception as file not found");
			System.exit(1);
		} catch (IOException e) {

			System.err.println("Exception due Stream Writer I/O operation ");
			System.exit(1);
		}

	}

	// Overriding toString method in FileProcessor class
	public String toString() {
		return "\nOverriding toString in FileProcessor Class";
	}

}
