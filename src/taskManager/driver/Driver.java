package taskManager.driver;


import taskManager.filter.DashboardFilter;
import taskManager.observers.DefaultTab;
import taskManager.observers.DefaultTabFilterImpl;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.observers.UsersTabFilterImpl;
import taskManager.subject.DashBoardSubject;
import taskManager.subject.Subject;
import taskManager.util.MyLogger;

public class Driver 
{
	public static void main(String[] args) 
	{
		
		if(args.length !=3)
		{
			System.err.println("Need to provide three arguments - inputfileName,outputfileName,debugValue");
			System.exit(1);
		}
		
		MyLogger.getInstance().setDebug(Integer.parseInt(args[2]));
		//Creating Subject
		Subject dashboard = new DashBoardSubject();
		
		//Creating Observers
		PerformanceTab performanceTab = new PerformanceTab(dashboard,args[1]); //o/p file name
		ProcessesTab processesTab = new ProcessesTab(dashboard,args[1]);
		UsersTab usersTab = new UsersTab(dashboard,args[1]);
		DefaultTab defaultTab =  new DefaultTab(dashboard, args[1]);
		
		//Creating filters
		DashboardFilter performanceFilter = new PerformanceTabFilterImpl();
		DashboardFilter processesFilter =  new ProcessesTabFilterImpl();
		DashboardFilter usersFilter =  new UsersTabFilterImpl();
		DashboardFilter defaultFilter =  new DefaultTabFilterImpl();
		
		//Registering Observers
		dashboard.registerObserver(performanceTab, performanceFilter);
		dashboard.registerObserver(processesTab, processesFilter);
		dashboard.registerObserver(usersTab, usersFilter);
		dashboard.registerObserver(defaultTab, defaultFilter);
		
		//Starting file processing
		((DashBoardSubject) dashboard).fileProcessing(args[0]); // read file name
	}
	
}
