/*
 * Name: Dennis Casaclang
 * Program: Business Information Technology
 * Course: ADEV-1008 Programming 1
 * Created: 2020-11-27
 * Updated: 2020-11-27
 */

/**
 * A program to test the GraduateApplicant class.
 *
 * @author Dennis Casaclang
 * @version 1.0
 */
public class GraduateApplicantTest
{
	public static void main(String[] args)
	{
		System.out.println("GraduateApplicant(String, String, String)");
		System.out.println("Test  #1 - Initialize the name.");
		constructor1_name_initialize();

		System.out.println("Test  #2 - Initialize the college.");
		constructor1_college_initialize();

		System.out.println("Test  #2 - Initialize the college of origin.");
		constructor1_collegeOfOrigin_initialize();

		System.out.println("setName(String) : void");
		System.out.println("Test  #1 - Update the state of name.");
		setName_name_updated();

		System.out.println("setCollege(String) : void");
		System.out.println("Test  #1 - Update the state of college.");
		setCollege_college_updated();

		System.out.println("setCollegeOfOrigin(String) : void");
		System.out.println("Test  #1 - Update the state of college origin.");
		setCollegeOfOrigin_collegeOfOrigin_updated();

		System.out.println("isInside() : boolean");
		System.out.println("Test  #1 - Returns true when the college and the college of origin are the same.");
		isInside_true_returns();

		System.out.println("Test  #2 - Returns true when the college and the college of origin are not the same.");
		isInside_false_returns();

		System.out.println("registerForProgram(String) : String");
		System.out.println("Test  #1 - Returns a String indicating the college of origin, college and program name.");
		registerForProgram_string_returns();

		System.out.println("toString() : String");
		System.out.println("Test #1 - Returns the correct string representation.");
		toString_returns();
	}

	/*
	 * GraduateApplicant(String, String, String)
     */

	public static void constructor1_name_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = name;
		String actual = target.getName();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	public static void constructor1_college_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = college;
		String actual = target.getCollege();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	public static void constructor1_collegeOfOrigin_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = collegeOfOrigin;
		String actual = target.getCollegeOfOrigin();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	 /**
	  * setName(String) : void
	  */

	 public static void setName_name_updated()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);
		String newName = "Morgan";
		target.setName(newName);

		String expected = newName;
		String actual = target.getName();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 /**
	  * setCollege(String) : void
	  */

 	 public static void setCollege_college_updated()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);
		String newCollege = "CDI College";
		target.setCollege(newCollege);

		String expected = newCollege;
		String actual = target.getCollege();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 /**
	  * setCollegeOfOrgin(String) : void
	  */

	 public static void setCollegeOfOrigin_collegeOfOrigin_updated()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Robertson College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);
		String newCollegeOfOrigin = "MITT";
		target.setCollegeOfOrigin(newCollegeOfOrigin);

		String expected = newCollegeOfOrigin;
		String actual = target.getCollegeOfOrigin();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 /**
	  * isInside() : boolean
	  */

	 public static void isInside_true_returns()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "Red River College";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = "true";
		String actual = Boolean.toString(target.isInside());

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 public static void isInside_false_returns()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "MITT";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = "false";
		String actual = Boolean.toString(target.isInside());

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 /**
	  * registerForProgram(String) : String
	  */

	 public static void registerForProgram_string_returns()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "MITT";
		String program = "Nursing";

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = "MITT > Red River College - Nursing";
		String actual = target.registerForProgram(program);

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	 }

	 /*
	  * toString() : String
 	  */

	 public static void toString_returns()
	 {
		String name = "Dennis";
		String college = "Red River College";
		String collegeOfOrigin = "MITT";

		StringBuilder stringBuilder = new StringBuilder();
		String lines = String.format("=======================%n");
		String collegeApplicant = String.format("College Applicant%n");

		stringBuilder.append(lines);
		stringBuilder.append(collegeApplicant);
		stringBuilder.append(lines);

		String nameOfStudent = String.format("Name:            %s%n", name);
		String nameOfCollege = String.format("College:         %s%n", college);
		String originCollege = String.format("Origin:          %s%n", collegeOfOrigin);

		stringBuilder.append(nameOfStudent);
		stringBuilder.append(nameOfCollege);
		stringBuilder.append(originCollege);

		GraduateApplicant target = new GraduateApplicant(name, college, collegeOfOrigin);

		String expected = stringBuilder.toString();
		String actual = target.toString();

		System.out.printf("Expected:%n%s%nActual:%n%s%n%n", expected, actual);
	 }
}