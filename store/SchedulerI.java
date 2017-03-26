package registrationScheduler.store;

import registrationScheduler.util.InputFileProcessorI;
import registrationScheduler.util.OutputFileProcessorI;

/**
* This interface will implement an method that will create a schedule for the
* student and write the schedule to output file.
*
* @author		Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public interface SchedulerI {

	/**
	* This method will create a schedule for the student and write the schedule to
	* output file.
	*
	* @param registrationFileProcessor 	processor to read registration time file.
	* @param preferenceFileProcessor		processor to read preferences file.
	* @param outputFileProcessor				processor to write to output file.
	*/
	public void writeScheduleToScreen(InputFileProcessorI registrationFileProcessor, InputFileProcessorI preferenceFileProcessor, OutputFileProcessorI outputFileProcessor);

}
