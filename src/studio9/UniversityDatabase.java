package studio9;

import java.util.Map;
import java.util.HashMap;

import assignment7.Student;


public class UniversityDatabase {
private final Map<String, Student> studentX; //can't initialize another map to use in its place -- "final"

	public UniversityDatabase() {
		this.studentX = new HashMap<>();
}

	public void addStudent(String accountName, Student student) {
		studentX.put(accountName, student);
	}

	public int getStudentCount() {
		return studentX.size();
	}

	public String lookupFullName(String accountName) {
		Student student = studentX.get(accountName); // lower case "student" here is from the parameter above in addStudent
		if (student == null) {
			return null;
		}
		else {
			return student.getFullName(); // using the "student" that met the non-null condition
			}
		}

	public double getTotalBearBucks() {
		// TODO
		double sum = 0; 
		for(String z: studentX.keySet()) {
			Student student = studentX.get(z);
			sum += student.getBearBucksBalance();	
		}	
		return sum;
	}
}
