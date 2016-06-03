package taskManager.subject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Hashtable;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class DashBoardSubject implements Subject {

	private Hashtable<Observer, DashboardFilter> observers;

	// Constructor
	public DashBoardSubject() {
		MyLogger.getInstance().printToStdout(2, "DEBUG MESSAGE FROM Constructor of DashBoardSubject");
		this.observers = new Hashtable<Observer, DashboardFilter>();
	}

	/***
	 * Register an Observer
	 */
	@Override
	public void registerObserver(Observer o, DashboardFilter filter)
	{
		MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM registerObserver");
		this.observers.put(o, filter);
	}

	/***
	 * Remove an Observer
	 */
	@Override
	public void removeObserver(Observer o) {
		MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM removeObserver");
		Boolean available = observers.containsKey(o);
		if (available) {
			this.observers.remove(o);
		}
	}

	/***
	 * Notify observers
	 */
	@Override
	public void notifyObservers(String dataMsg) {
		MyLogger.getInstance().printToStdout(3, "DEBUG MESSAGE FROM notifyObservers Method");
		// retrieve filters and observer references
		// apply filter to determine if the observer should be updated
		// assume filterRef has been retrieved for an observer, obs.
		String[] data = dataMsg.split("\\*");

		data[0] = "Begin" + data[0];
		data[(data.length) - 1] = data[data.length - 1] + "End";

		for (int i = 0; i < data.length; i++) {
			Enumeration<Observer> e = observers.keys();
			while (e.hasMoreElements()) {
				Observer key = (Observer) e.nextElement();
				if (this.observers.get(key).check(data[i])) {
					key.update(data[i]);
				}
			}
		}
	}

	/***
	 * Method to read from a file with fileName provided
	 * 
	 * @param fileName
	 */
	public void fileProcessing(String fileName) {
		MyLogger.getInstance().printToStdout(3,"DEBUG MESSAGE FROM fileProcessing Startup method");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			FileProcessor fProcessor = new FileProcessor(reader, fileName);
			String inputLine = null;
			while ((inputLine = fProcessor.readFromFile()) != null) {
				notifyObservers(inputLine);
			}

		} 
		catch (FileNotFoundException e) {
			MyLogger.getInstance().printToStdout(0,"DEBUG MESSAGE FROM FileNotFound catch block of fileProcessing method in DashBoardSubject");
			System.err.println("Exception as file not found in fileProcessing method of DashboardSubject");
			System.exit(1);
		}
		
	}

	// Overriding toString method in DashBoardSubject class
	public String toString() {
		return "\nOverriding toString in DashBoardSubject Class";
	}

}
