package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucks;
	
	/**
	 * Default constructor
	 * @param firstName
	 * @param lastName
	 */
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		studentID = 0;
		attemptedCredits = 0;
		passingCredits = 0;
		totalGradeQualityPoints = 0;
		bearBucks = 0;
	}
	
	/**
	 * Constructor with student ID parameter
	 * @param firstName
	 * @param lastName
	 * @param studentID
	 */
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		attemptedCredits = 0;
		passingCredits = 0;
		totalGradeQualityPoints = 0;
		bearBucks = 0;
	}
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @return student's full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * 
	 * @return studentID
	 */
	public int getId() {
		return studentID;
	}
	
	/**
	 * 
	 * @return attemptedCredits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * 
	 * @return passingCredits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints/attemptedCredits;
	}
	
	/**
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		attemptedCredits += credits;
		totalGradeQualityPoints += grade*credits;
		if (grade >= 1.7) {
			passingCredits += credits;
		}
	}
	
	/**
	 * 
	 * @return grade level of a student
	 */
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}
		else if (30 <= passingCredits && passingCredits < 60) {
			return "Sophomore";
		}
		else if (60 <= passingCredits && passingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	/**
	 * 
	 * @return eligibility for the fraternity
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (passingCredits >= 98 && calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else if (passingCredits >= 75 && calculateGradePointAverage() >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		bearBucks += amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		bearBucks -= amount;
	}
	
	/**
	 * 
	 * @return bearBucks
	 */
	public double getBearBucksBalance() {
		return bearBucks;
	}
	
	/**
	 * 
	 * @return bearBucks
	 */
	public double cashOutBearBucks() {
		if (bearBucks > 10) {
			double temp = bearBucks;
			bearBucks = 0;
			return temp - 10;
		}
		else {
			bearBucks = 0;
			return 0;
		}
	}
	
	/**
	 * 
	 * @param firstName for the child
	 * @param otherParent 
	 * @param isHyphenated last name
	 * @param id
	 * @return a child student parented by instance parent and the parameter parent
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String legacyLastName;
		if (isHyphenated) {
			legacyLastName = getLastName() + "-" + otherParent.getLastName();
		}
		else {
			legacyLastName = getLastName();
		}
		Student legacy = new Student(firstName, legacyLastName, id);
		legacy.depositBearBucks(cashOutBearBucks() + otherParent.cashOutBearBucks());
		return legacy;
	}
	
	public String toString() {
		return getFullName() + ": " + studentID;
	}
}
