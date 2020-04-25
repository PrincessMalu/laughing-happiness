
/**
 * Constructs the college student object The constructor takes 7 parameter and
 * extends the Students class. Two additional parameters are added, major and
 * year. There are setter and getter methods for each of them.
 *
 * @author Malavika Nair
 * @version Oct 18, 2019
 * @author Period: 1st
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class CollegeStudent extends Student
{
    private int myYear; // Student Year in College

    private String myMajor; // Student's major


    /**
     * @param name
     *            name of the student
     * @param age
     *            age of the student
     * @param gender
     *            gender of the student
     * @param idNum
     *            idNum of the student
     * @param gpa
     *            gpa of the student
     * @param year
     *            students year in college
     * @param major
     *            the students major
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa,
        int year,
        String major )
    {

        super( name, age, gender, idNum, gpa );

        myYear = year;
        myMajor = major;
    }


    /**
     * gets the students major
     * 
     * @return the major of the student
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * gets the students year
     * 
     * @return the year of the student
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * Sets the students major to a certain specified major
     * 
     * @param major
     *            what major the student is in
     */
    public void setMajor( String major )
    {
        myMajor = major;
    }


    /**
     * sets the students year to a given year
     * 
     * @param year
     *            what is the students current year in college
     */
    public void setYear( int year )
    {
        myYear = year;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
