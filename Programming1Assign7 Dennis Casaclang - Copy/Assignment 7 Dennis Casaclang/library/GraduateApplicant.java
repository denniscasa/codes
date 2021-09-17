/*
 * Name: Dennis Casaclang
 * Program: Business Information Technology
 * Course: ADEV-1008 Programming 1
 * Created: 2020-11-27
 * Updated: 2020-11-27
 */

/**
 * Class encapsulating the concept of Graduate Applicant.
 *
 * @author Dennis Casaclang
 * @version 1.0
 */
public class GraduateApplicant extends CollegeApplicant
{
	private String collegeOfOrigin;

	/**
		 * Initialize an instance of the GraduateApplicant class with a specified name,
		 * college name, and college of origin.
		 *
		 * @param name The name of the college applicant.
		 * @param college The name of the college.
		 * @param collegeOfOrigin The name of the college where the graduate applicant received their degree.
	 */
	public GraduateApplicant(String name, String college, String collegeOfOrigin)
	{
		super(name, college);
		this.collegeOfOrigin = collegeOfOrigin;
	}

	/**
		 * Returns the college of origin.
		 *
		 * @return collegeOfOrigin The name of the college where the graduate applicant received their degree.
	 */
	public String getCollegeOfOrigin()
	{
		return this.collegeOfOrigin;
	}

	/**
		 * Sets the college of origin.
		 *
		 * @param collegeOfOrigin The name of the college where the graduate applicant received their degree.
	 */
	public void setCollegeOfOrigin(String collegeOfOrigin)
	{
		this.collegeOfOrigin = collegeOfOrigin;
	}

	/**
		 * Returns true when the college name and the college of origin are the
		 * same(case should not be a factor) otherwise false.
		 *
		 * @return boolean True when the college name and the college of origin are the
		 * same(case should not be a factor) otherwise false.
	 */
	public boolean isInside()
	{
		return this.getCollege().equalsIgnoreCase(this.collegeOfOrigin);
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
		return String.format("%s > %s - %s", this.collegeOfOrigin, this.getCollege(), program);
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
		String originCollege = String.format("Origin:          %s%n", this.collegeOfOrigin);

		stringBuilder.append(previousString);
		stringBuilder.append(originCollege);

		return stringBuilder.toString();
	}
}