package registrationScheduler.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
* This class will implement OutputFileProcessorI interface.
*
* @author		Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public class OutputFileProcessor implements OutputFileProcessorI{

	private BufferedWriter writer = null;

	/**
	* Constructs an object that will instanciates BufferedWriter given the file
	* name.
	*
	* @param fileNameIn	string containig name of the file.
	*/
	public OutputFileProcessor(String fileNameIn) {
		try {
			writer = new BufferedWriter(new FileWriter(new File(fileNameIn)));
		} catch (IOException exception) {
			System.err.println("Cannot create output file." + exception.getStackTrace().toString());
			System.exit(1);
		} finally {

		}
	}

	@Override
	public void closeFile() {
		try {
			writer.close();
		} catch (IOException exception) {
			System.err.println("Error while closing the file." + exception.getStackTrace().toString());
			System.exit(1);
		} finally {

		}
	}

	@Override
	public void writeLine(String content) {
		try {
			writer.write(content);
		} catch (IOException exception) {
			System.err.println("Error while writing to file." + exception.getStackTrace().toString());
		} finally {

		}
	}

	@Override
	public String toString() {
		return "OutputFileProcessor [writer=" + writer + "]";
	}

}
