
/**
 * Constructs the student object The constructor takes 5 parameter and extends
 * the Person class. Two additional parameters are added, idnum and gpa. There
 * are setter and getter methods for each of them.
 *
 * @author Malavika Nair
 * @version Oct 18, 2019
 * @author Period: 1st
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Student extends Person
{
    private String myIdNum; // Student Id Number

    private double myGPA; // grade point average


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
     */
    public Student(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }


    /**
     * A getter method for the field idNum
     * 
     * @return returns the ID Number of the student
     */
    public String getIdNum()
    {
        return myIdNum;
    }


    /**
     * A getter method for the field gpa
     * 
     * @return returns the gpa of a specified student
     */
    public double getGPA()
    {
        return myGPA;
    }


    /**
     * a setter method for the String field idNum
     * 
     * @param idNum
     *            - the entered idNum for the student.
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }


    /**
     * A setter method for the double field gpa
     * 
     * @param gpa
     *            - the entered gpa of a student.
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + ", gpa: "
            + myGPA;
    }
}
