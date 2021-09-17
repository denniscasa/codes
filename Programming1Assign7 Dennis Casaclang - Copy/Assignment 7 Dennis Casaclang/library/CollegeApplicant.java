/*
 * Name: Dennis Casaclang
 * Program: Business Information Technology
 * Course: ADEV-1008 Programming 1
 * Created: 2020-11-27
 * Updated: 2020-11-27
 */

/**
 * Class encapsulating the concept of College Applicant
 *
 * @author Dennis Casaclang
 * @version 1.0
 */
public abstract class CollegeApplicant
{
	private String name;
	private String college;

	/**
		 * Initialize an instance of the CollegeApplicant class where the name
		 * and college are set to "unknown".
	 */
	public CollegeApplicant()
	{
		name = "unknown";
		college = "unknown";
	}

	/**
		 * Initialize an instance of the CollegeApplicant class where the name and
		 * college are set to the specified values.
		 *
		 * @param name The name of the college applicant.
		 * @param college The name of the college.
	 */
	public CollegeApplicant(String name, String college)
	{
		this.name = name;
		this.college = college;
	}

	/**
		 * Returns the college applicant's name.
		 *
		 * @return name The name of the college applicant.
	 */
	public String getName()
	{
		return this.name;
	}

	/**
		 * Sets the college applicant's name.
		 *
		 * @param name The name of the college applicant.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
		 * Returns the name of the college.
		 *
		 * @return college The name of the college.
	 */
	public String getCollege()
	{
		return this.college;
	}

	/**
		 * Sets the name of the college.
		 *
		 * @param college The name of the college.
	 */
	public void setCollege(String college)
	{
		this.college = college;
	}


	/**
		 * Returns a String representing the registration of a program.
		 *
		 * @param program The name of the program.
		 * @return String The String representing the registration of a program.
	 */
	public abstract String registerForProgram(String program);

	/**
		 * Returns the String representation of the class.
		 *
		 * @return the String representation of the class.
	 */
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		String lines = String.format("=======================%n");
		String collegeApplicant = String.format("College Applicant%n");

		stringBuilder.append(lines);
		stringBuilder.append(collegeApplicant);
		stringBuilder.append(lines);

		String nameOfStudent = String.format("Name:            %s%n", this.name);
		String nameOfCollege = String.format("College:         %s%n", this.college);

		stringBuilder.append(nameOfStudent);
		stringBuilder.append(nameOfCollege);

		return stringBuilder.toString();
	}

}