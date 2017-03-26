package registrationScheduler.store;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import registrationScheduler.store.Student;
import registrationScheduler.util.InputFileProcessorI;
import registrationScheduler.util.OutputFileProcessorI;

/**
* This Scheduler will implement SchedulerI
*
* @author		Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public class Scheduler implements SchedulerI {

	private static final int maxClassSize = 20;
	private static Map<String, Integer> classSize = new HashMap<String, Integer>();
	private static double averagePreferenceScore = 0;

	/**
	* Constructs the Scheduler object and initializes the classSize map.
	*/
	public Scheduler() {
			classSize.put("A", 0);
			classSize.put("B", 0);
			classSize.put("C", 0);
			classSize.put("D", 0);
			classSize.put("E", 0);
			classSize.put("F", 0);
			classSize.put("G", 0);
			classSize.put("H", 0);
	}

	/**
	*	This method will assign courses to students according to given prefrences.
	*
	* @param studentIn 	object of Student to which courses are to be allocated.
	* @param index			preference number.
	*/
	private static void assignPreference(Student studentIn, int index) {
		int currentClassSize = classSize.get(studentIn.getPreferenceList().get(index));
		if (maxClassSize >= currentClassSize + 1) {
			classSize.put(studentIn.getPreferenceList().get(index), ++currentClassSize);
			studentIn.getCourseSchedule().add(index, studentIn.getPreferenceList().get(index));
			studentIn.setPreferenceScore(studentIn.getPreferenceScore() + (index + 1));
		} else {
			for(Map.Entry<String, Integer> entry : classSize.entrySet()) {
				int newClassSize = entry.getValue();
				if(maxClassSize >= newClassSize + 1 && !studentIn.getCourseSchedule().contains(entry.getKey())) {
					classSize.put(entry.getKey(), ++newClassSize);
					studentIn.getCourseSchedule().add(index, entry.getKey());
					studentIn.setPreferenceScore(studentIn.getPreferenceScore() + 5);
					return;
				}
			}
			studentIn.getCourseSchedule().add(index, null);
			studentIn.setPreferenceScore(studentIn.getPreferenceScore() + 6);
			return;
		}
	}

	private static void scheduleCourses(Queue<Student> studentRegistrationQueueIn) {
		for(int index = 0; index < 4; index++){
			for(Student student : studentRegistrationQueueIn){
				assignPreference(student, index);
			}
		}
	}

	@Override
	public void writeScheduleToScreen(InputFileProcessorI registrationFileProcessor, InputFileProcessorI preferenceFileProcessor, OutputFileProcessorI outputFileProcessor) {
		String currentRegistrationTime, currentPreferenceStudent;
		String[] studentRegistrationTime, studentPreference;
		Student newStudent = null;
		List<String> tempPreference = null;
		Queue<Student> studentRegistrationQueue = new PriorityQueue<Student>(50, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2){
				return s1.getRegistrationTime() - s2.getRegistrationTime();
			}
		});
		try {
			while (null != (currentRegistrationTime = registrationFileProcessor.readLine()) && null != (currentPreferenceStudent = preferenceFileProcessor.readLine())) {
				studentRegistrationTime = currentRegistrationTime.split("\\s+");
				newStudent = new Student(studentRegistrationTime[0], Integer.parseInt(studentRegistrationTime[1]));
				tempPreference = new ArrayList<String>();
				studentPreference = currentPreferenceStudent.split("\\s+");
				tempPreference.add(studentPreference[1]);
				tempPreference.add(studentPreference[2]);
				tempPreference.add(studentPreference[3]);
				tempPreference.add(studentPreference[4]);
				newStudent.setPreferenceList(tempPreference);
				studentRegistrationQueue.offer(newStudent);
			}
			scheduleCourses(studentRegistrationQueue);
			for(Student student : studentRegistrationQueue){
				averagePreferenceScore = averagePreferenceScore + student.getPreferenceScore();
				outputFileProcessor.writeLine(student.getStudentName() + " ");
				for(String course : student.getCourseSchedule()) {
					outputFileProcessor.writeLine(course + " ");
				}
				outputFileProcessor.writeLine(Double.toString(student.getPreferenceScore()));
				outputFileProcessor.writeLine("\n");
			}
			outputFileProcessor.writeLine("Average preference_score is: " + Double.toString(averagePreferenceScore/50));
			outputFileProcessor.closeFile();
		} catch (NumberFormatException exception){
			System.err.println("Invalid input.");
			exception.printStackTrace();
			System.exit(1);
		} finally {
			registrationFileProcessor.closeFile();
			preferenceFileProcessor.closeFile();
		}
	}
}
