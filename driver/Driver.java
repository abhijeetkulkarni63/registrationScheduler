package registrationScheduler.driver;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.NumberFormatException;

import registrationScheduler.util.InputFileProcessorI;
import registrationScheduler.util.OutputFileProcessor;
import registrationScheduler.util.OutputFileProcessorI;
import registrationScheduler.util.InputFileProcessor;
import registrationScheduler.store.Scheduler;
import registrationScheduler.store.SchedulerI;
import registrationScheduler.util.Logger;

/**
*	The driver call implements an application that generates the schedule of
* courses for a student given the registration time and course preference.
*
* @author 	Abhijeet Kulkarni
* @version	1.0
* @version	2017-02-12
*/
public class Driver {

	/**
	 * Returns a boolean value 'true' if arguments to the program are in correct
	 * sequence and are of proper type.
	 *
	 * @param 	args	a string containig command line arguments.
	 * @return				boolean value indicating validation of command line argument
	*/
	private boolean validateArgs(String[] args) {
		try {
			if (4 != args.length) {
				System.err.println("Please Enter Valid Number of Arguments: ");
				System.exit(1);
			}
			int debugLevel = Integer.parseInt(args[3]);
			for (int i = 0; i < 3; i++) {
				File file = new File(args[i]);
				if (!file.exists())
					file.createNewFile();
				if (file.isFile() && file.canRead()) {
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
					} catch (FileNotFoundException exception) {
						System.err.println("Could Not Read File. ");
						exception.printStackTrace();
						System.exit(1);
					} finally {

					}
				} else {
					System.err.println("Enter Valid File.");
					System.exit(1);
				}
			}
		} catch(IOException | NumberFormatException exception) {
			System.err.println("Debug Level should a value.");
			exception.printStackTrace();
			System.exit(1);
		} catch (IOException exception) {
			System.err.println("File does not exists.");
			exception.printStackTrace();
			System.exit(1);
		} finally {

		}
		return true;
	}

	public static void main(String[] args) {

		Driver driver = new Driver();
		if (!driver.validateArgs(args)) {
			System.exit(1);
		}
		Logger.setDebugValue(Integer.parseInt(args[3]));
		InputFileProcessorI registrationFileProcessor = new InputFileProcessor(args[0]);
		InputFileProcessorI preferenceFileProcessor = new InputFileProcessor(args[1]);
		OutputFileProcessorI outputFileProcess = new OutputFileProcessor(args[2]);
		SchedulerI scheduler = new Scheduler();
		scheduler.writeScheduleToScreen(registrationFileProcessor, preferenceFileProcessor, outputFileProcess);
	}
}
