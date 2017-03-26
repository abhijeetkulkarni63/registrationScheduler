package registrationScheduler.util;

/**
* This interface provides methods to process an output file.
* writeLine method is used to write the 'content' to the file.
* closeFile method closes the file.
*
* @author 	Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public interface OutputFileProcessorI {

	/**
	* This method will write the 'content' to the file.
	*
	* @param	content	string that will be written to the file.
	*/
	public void writeLine(String content);

	/**
	* This method will close the file.
	*/
	public void closeFile();
}
