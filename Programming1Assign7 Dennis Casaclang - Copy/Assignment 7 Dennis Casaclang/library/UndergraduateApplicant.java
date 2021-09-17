/*
 * Name: Dennis Casaclang
 * Program: Business Information Technology
 * Course: ADEV-1008 Programming 1
 * Created: 2020-11-27
 * Updated: 2020-11-27
 */

/**
 * Class encapsulating the concept of Undergraduate Applicant.
 *
 * @author Dennis Casaclang
 * @version 1.0
 */
public class UndergraduateApplicant extends CollegeApplicant
{
	private double standardAptitudeTestScore;
	private double gradePointAverage;

	/**
		 * Initializes an instance of the UndergraduateApplicant class with the specified
		 * applicant name, college name, standard aptitude test score and grade point average.
		 *
		 * @param name The name of the college applicant.
		 * @param college The name of the college.
		 * @param standardAptitudeTestScore The score achieved on the standard aptitude test.
		 * @param gradePointAverage The applicants grade point average.
	 */
	public UndergraduateApplicant(String name, String college, double standardAptitudeTestScore, double gradePointAverage)
	{
		super(name, college);

		setStandardAptitudeTestScore(standardAptitudeTestScore);
		setGradePointAverage(gradePointAverage);
	}

	/**
		 * Returns the standard aptitude test score.
		 *
		 * @return standardAptitudeTestScore The score achieved on the standard aptitude test.
	 */
	public double getStandardAptitudeTestScore()
	{
		return this.standardAptitudeTestScore;
	}

	/**
		 * Sets the standard aptitude test score.
		 *
		 * @param standardAptitudeTestScore The score achieved on the standard aptitude test.
	 */
	public void setStandardAptitudeTestScore(double standardAptitudeTestScore)
	{
		if(standardAptitudeTestScore >= 0 && standardAptitudeTestScore <= 500)
		{
			this.standardAptitudeTestScore = standardAptitudeTestScore;
		}
		else
		{
			this.standardAptitudeTestScore = 0;
		}
	}

	/**
		 * Returns the grade point average.
		 *
		 * @return gradePointAverage The applicants grade point average.
	 */
	public double getGradePointAverage()
	{
		return this.gradePointAverage;
	}

	/**
		 * Sets the grade point average.
		 *
		 * @param gradePointAverage The applicants grade point average.
	 */
	public void setGradePointAverage(double gradePointAverage)
	{
		if(gradePointAverage >= 0 && gradePointAverage <= 4.5)
		{
			this.gradePointAverage = gradePointAverage;
		}
		else
		{
			this.gradePointAverage = 0;
		}
	}

	/**
		 * Returns a String representing the registration of a program.
		 *
		 * @param program The name of the program.
		 * @return String A String representing the registration of a program.
	 */
	@Override
	public String registerForProgram(String program)
	{
		return String.format("%s - %s [%.1f]", this.getCollege(), program, this.standardAptitudeTestScore);
	}

	/**
		 * Returns the String representation of the class.
		 *
		 * @return the String representation of the class.
	 */
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		String previousString = super.toString();
		String standardTestScore = String.format("SAT Score:       %.1f%n", this.standardAptitudeTestScore);
		String gpaScore = String.format("GPA:             %.2f%n", this.gradePointAverage);

		stringBuilder.append(previousString);
		stringBuilder.append(standardTestScore);
		stringBuilder.append(gpaScore);

		return stringBuilder.toString();
	}
}