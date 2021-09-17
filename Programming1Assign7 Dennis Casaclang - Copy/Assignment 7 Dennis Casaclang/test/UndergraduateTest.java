/*
 * Name: Dennis Casaclang
 * Program: Business Information Technology
 * Course: ADEV-1008 Programming 1
 * Created: 2020-11-27
 * Updated: 2020-11-27
 */

/**
 * A program to test the UndergraduateApplicant class.
 *
 * @author Dennis Casaclang
 * @version 1.0
 */
public class UndergraduateTest
{
	public static void main(String[] args)
	{
		System.out.println("UndergraduateApplicant(String, String, double, double)");
		System.out.println("Test  #1 - Initialize the name.");
		constructor1_name_initialize();

		System.out.println("Test  #2 - Initialize the college.");
		constructor1_college_initialize();

		System.out.println("Test  #3 - Initialize the mark achieved on the standard aptitude test below the allowable range.");
		constructor1_testBelowRange_initialize();

		System.out.println("Test  #4 - Initialize the mark achieved on the standard aptitude test above the allowable range.");
		constructor1_testAboveRange_initialize();

		System.out.println("Test  #5 - Initialize the mark achieved on the standard aptitude test at the edge of the allowable range.");
		constructor1_testMaxRange_initialize();

		System.out.println("Test  #6 - Initialize the mark achieved on the standard aptitude test.");
		constructor1_testWithinRange_initialize();

		System.out.println("Test  #7 - Initialize the applicants grade point average below the allowable range.");
		constructor1_gradeBelowRange_initialize();

		System.out.println("Test  #8 - Initialize the applicants grade point average above the allowable range.");
		constructor1_gradeAboveRange_initialize();

		System.out.println("Test  #9 - Initialize the applicants grade point average at the edge of the allowable range.");
		constructor1_gradeMaxRange_initialize();

		System.out.println("Test  #10 - Initialize the applicants grade point average.");
		constructor1_gradeWithinRange_initialize();

		System.out.println("setStandardAptitudeTestScore(double) : void");
		System.out.println("Test  #1 - Update the mark achieved on the standard aptitude test below the allowable range.");
		setStandardAptitudeTestScore_belowRange_returns();

		System.out.println("Test  #2 - Update the mark achieved on the standard aptitude test above the allowable range.");
		setStandardAptitudeTestScore_aboveRange_returns();

		System.out.println("Test  #3 - Update the mark achieved on the standard aptitude test at the edge of the allowable range.");
		setStandardAptitudeTestScore_maxRange_returns();

		System.out.println("Test  #4 - Update the mark achieved on the standard aptitude test.");
		setStandardAptitudeTestScore_withinRange_returns();

		System.out.println("setGradePointAverage() : double");
		System.out.println("Test  #1 - Update the applicants grade point average below the allowable range.");
		setGradePointAverage_belowRange_returns();

		System.out.println("Test  #2 - Update the applicants grade point average above  the allowable range.");
		setGradePointAverage_aboveRange_returns();

		System.out.println("Test  #3 - Update the applicants grade point average at the edge of the  allowable range.");
		setGradePointAverage_maxRange_returns();

		System.out.println("Test  #4 - Update the applicants grade point average.");
		setGradePointAverage_withinRange_returns();

		System.out.println("registerForProgram(String) : String");
		System.out.println("Test  #1 - Returns a String indicating the college, program name, and aptitude test score.");
		registerForProgram_String_returns();

		System.out.println("toString() : String");
		System.out.println("Test #1 - Return correct string representation of UndergraduateApplicant.");
		toString_returns();
	}

	/**
	 * UndergraduateApplicant(String, String, double, double)
	 */

	public static void constructor1_name_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		String expected = name;
		String actual = target.getName();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	public static void constructor1_college_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		String expected = college;
		String actual = target.getCollege();

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	public static void constructor1_testBelowRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = -222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 0;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_testAboveRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 777;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 0;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_testMaxRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 500;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 500;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_testWithinRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 222;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_gradeBelowRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = -2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 0;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_gradeAboveRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 7.7;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 0;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_gradeMaxRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 4.5;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 4.5;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void constructor1_gradeWithinRange_initialize()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		double expected = 2.2;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	/**
	 * setStandardAptitudeTestScore(double) : void
	 */

	public static void setStandardAptitudeTestScore_belowRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newScore = -222;
		target.setStandardAptitudeTestScore(newScore);

		double expected = 0;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setStandardAptitudeTestScore_aboveRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newScore = 777;
		target.setStandardAptitudeTestScore(newScore);

		double expected = 0;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setStandardAptitudeTestScore_maxRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newScore = 500;
		target.setStandardAptitudeTestScore(newScore);

		double expected = 500;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setStandardAptitudeTestScore_withinRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newScore = 333;
		target.setStandardAptitudeTestScore(newScore);

		double expected = 333;
		double actual = target.getStandardAptitudeTestScore();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	/**
	 * setGradePointAverage() : double
	 */

	public static void setGradePointAverage_belowRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newGrade = -2.2;
		target.setGradePointAverage(newGrade);

		double expected = 0;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setGradePointAverage_aboveRange_returns()
		{
			String name = "Dennis";
			String college = "Red River College";
			double standardAptitudeTestScore = 222;
			double gradePointAverage = 7.7;

			UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
			double newGrade = -2.2;
			target.setGradePointAverage(newGrade);

			double expected = 0;
			double actual = target.getGradePointAverage();

			System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setGradePointAverage_maxRange_returns()
		{
			String name = "Dennis";
			String college = "Red River College";
			double standardAptitudeTestScore = 222;
			double gradePointAverage = 2.2;

			UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
			double newGrade = 4.5;
			target.setGradePointAverage(newGrade);

			double expected = 4.5;
			double actual = target.getGradePointAverage();

			System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	public static void setGradePointAverage_withinRange_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);
		double newGrade = 3.3;
		target.setGradePointAverage(newGrade);

		double expected = 3.3;
		double actual = target.getGradePointAverage();

		System.out.printf("Expected: %f%nActual: %f%n%n", expected, actual);
	}

	/**
	 * registerForProgram(String) : String
	 */

	public static void registerForProgram_String_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;
		String program = "Business Information Technology";

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		String expected = "Red River College - Business Information Technology [222.0]";
		String actual = target.registerForProgram(program);

		System.out.printf("Expected: %s%nActual: %s%n%n", expected, actual);
	}

	/**
	 * toString() : String
	 */
	public static void toString_returns()
	{
		String name = "Dennis";
		String college = "Red River College";
		double standardAptitudeTestScore = 222;
		double gradePointAverage = 2.2;

		StringBuilder stringBuilder = new StringBuilder();
		String lines = String.format("=======================%n");
		String collegeApplicant = String.format("College Applicant%n");

		stringBuilder.append(lines);
		stringBuilder.append(collegeApplicant);
		stringBuilder.append(lines);

		UndergraduateApplicant target = new UndergraduateApplicant(name, college, standardAptitudeTestScore, gradePointAverage);

		String nameOfStudent = String.format("Name:            %s%n", name);
		String nameOfCollege = String.format("College:         %s%n", college);

		stringBuilder.append(nameOfStudent);
		stringBuilder.append(nameOfCollege);

		String standardTestScore = String.format("SAT Score:       %.1f%n", standardAptitudeTestScore);
		String gpaScore = String.format("GPA:             %.2f%n", gradePointAverage);

		stringBuilder.append(standardTestScore);
		stringBuilder.append(gpaScore);

		String expected = stringBuilder.toString();
		String actual = target.toString();

		System.out.printf("Expected:%n%s%nActual:%n%s%n%n", expected, actual);


	}
}