package registrationScheduler.util;

/**
* This interface provides methods to process an input file.
* readLine method is used to read a line from the file.
* closeFile method closes the file.
*
* @author 	Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public interface InputFileProcessorI  {

  /**
  * This method will read a line from the file.
  *
  * @return	string that will contain line read from the file.
  */
  public String readLine();

  /**
  * This method will close the file.
  */
  public void closeFile();
}
