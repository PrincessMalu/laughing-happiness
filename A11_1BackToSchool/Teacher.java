
/**
 * Constructs the teacher object The constructor takes 5 parameter in total and
 * extends the Person class. Two additional parameters are added, subject and
 * salary. There are setter and getter methods for each of them.
 *
 * @author Malavika Nair
 * @version Oct 18, 2019
 * @author Period: 1st
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Teacher extends Person
{
    private String mySubject; // Subject that they teach

    private double mySalary; // Salary


    /**
     * @param name
     *            name of the teacher
     * @param age
     *            age of the teacher
     * @param gender
     *            gender of the teacher
     * @param subject
     *            the specific subject that the teacher teaches
     * @param salary
     *            the teachers salary
     */
    public Teacher(
        String name,
        int age,
        String gender,
        String subject,
        double salary )
    {
        super( name, age, gender );

        mySalary = salary;
        mySubject = subject;
    }


    /**
     * A getter method for the field Subject
     * 
     * @return returns the subject that the teacher teaches.
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * A getter method for the field Salary
     * 
     * @return returns the salasry of a specific teacher
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * A setter method for the String field subject
     * 
     * @param subject
     *            the entered subject tha tthe teacher teaches.
     */
    public void setSubject( String subject )
    {
        mySubject = subject;
    }


    /**
     * a setter method for the double field salary
     * 
     * @param salary
     *            - the entered salary of the teacher.
     */
    public void setSalary( double salary )
    {
        mySalary = salary;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }
}
