package registrationScheduler.store;

import java.util.List;
import java.util.ArrayList;
/**
* This class encapsulates the details of a student such as Student Name, his/her
* registration time for course, preference list of courses, list of assigned
* courses and preference score.
* @author		Abhijeet Kulkarni
* @version	1.0
* @since		2017-02-12
*/
public class Student {
	private String studentName;
	private int registrationTime;
	private List<String> preferenceList;
	private List<String> courseSchedule;
	private double preferenceScore;

	/**
	* Constructs a Student object with specified Student Name and registration
	* time and initializes the preference list and schedule list.
	*
	* @param	studentNameIn				string containig name of the student.
	* @param	registrationTimeIn	registration time for the student.
	*/
	public Student(String studentNameIn, int registrationTimeIn){
		studentName = studentNameIn;
		registrationTime = registrationTimeIn;
		preferenceList = new ArrayList<String>();
		courseSchedule = new ArrayList<String>(8);
		preferenceScore = 0;
	}

	/**
	* return name of the student.
	*
	* @return	name of the student.
	*/
	public String getStudentName() {
		return studentName;
	}

	/**
	* sets name of the student.
	*
	* @param	studentNameIn	name of the student.
	*/
	public void setStudentName(String studentNameIn) {
		studentName = studentNameIn;
	}

	/**
	* return registration time of the student.
	*
	* @return	registration time of the student.
	*/
	public int getRegistrationTime() {
		return registrationTime;
	}

	/**
	* sets registration time of the student.
	*
	* @param	registrationTimeIn	registration time of the student.
	*/
	public void setRegistrationTime(int registrationTimeIn) {
		registrationTime = registrationTimeIn;
	}

	/**
	* return list of preferences of the student.
	*
	* @return	list of preferences of the student.
	*/
	public List<String> getPreferenceList() {
		return preferenceList;
	}

	/**
	* sets preference list of the student.
	*
	* @param	preferenceListIn	list of course preferences for the student.
	*/
	public void setPreferenceList(List<String> preferenceListIn) {
		preferenceList = preferenceListIn;
	}

	/**
	* sets list of courses assigned for the student.
	*
	* @param	courseScheduleIn	list of coures assigned for the student.
	*/
	public void setCourseSchedule(List<String> courseScheduleIn) {
		courseSchedule = courseScheduleIn;
	}

	/**
	* return list of courses assigned of the student.
	*
	* @return	list of courses assigned of the student.
	*/
	public List<String> getCourseSchedule() {
		return courseSchedule;
	}

	/**
	* returns preference score of the student.
	*
	* @return	preference score of the student.
	*/
	public double getPreferenceScore() {
		return preferenceScore;
	}

	public void setPreferenceScore(double preferenceScoreIn) {
		preferenceScore = preferenceScoreIn;
	}

	@Override
	public String toString() {
		return "Student Name = " + studentName + ", Registration Time = " + registrationTime + ", Preference List = "
				+ preferenceList + ", Course Schedule = " + courseSchedule + "Preference Score = " + preferenceScore;
	}
}
