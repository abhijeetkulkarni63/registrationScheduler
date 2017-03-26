package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
* This class will implement InputFileProcessorI interface.
*
* @author		Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public class InputFileProcessor implements InputFileProcessorI {
	private BufferedReader reader = null;

	/**
	* Constructs an object that will instanciates BufferedReader given the file
	* name.
	*
	* @param fileNameIn	string containig name of the file.
	*/
	public InputFileProcessor(String fileNameIn) {
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileNameIn))));
		} catch (FileNotFoundException exception) {
			System.err.println("Please Specify Correct Path." + exception.getStackTrace().toString());
			System.exit(1);
		} finally {

		}
	}

	@Override
	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException exception) {
			System.err.println("Error while reading the file." + exception.getStackTrace().toString());
			System.exit(1);
		} finally {

		}
		return null;
	}

	@Override
	public void closeFile() {
		try {
			reader.close();
		} catch (IOException exception) {
			System.err.println("Error while closing the file." + exception.getStackTrace().toString());
			System.exit(1);
		} finally {

		}
	}

	@Override
	public String toString() {
		return "InputFileProcessor [reader=" + reader + "]";
	}
}
