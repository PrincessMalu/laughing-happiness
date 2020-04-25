
/**
 * This class is the super class for both the student class and the teacher
 * class. It only has 3 basic parameters, name age and gender. There are setter and
 * getter methods for all three of the parameter. All three parameters are
 * defined a private fields. TODO Follow it with additional details about its
 * purpose, what abstraction it represents, and how to use it.
 *
 * @author Malavika Nair
 * @version Oct 18, 2019
 * @author Period: 1st
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Person
{
    private String myName; // name of the person

    private int myAge; // person's age

    private String myGender; // 'M' for male, 'F' for female


    /**
     * @param name name of the person.
     * @param age age of the person.
     * @param gender gender of the person.
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }


    /**
     * The method is the getter method for name
     * @return the name of the person
     */
    public String getName()
    {
        return myName;
    }


    /**
     * The method is the getter method for age
     * @return the age of the person
     */
    public int getAge()
    {
        return myAge;
    }


    /**
     * The method is the getter method for gender.
     * @return the gender of the person
     */
    public String getGender()
    {
        return myGender;
    }


    /**
     * The setter method for the name of a person
     * @param name the string that specifies the name of the person
     */
    public void setName( String name )
    {
        myName = name;
    }


    /**
     * The setter method for the age of a person
     * @param age the string that specifies the age of the person
     */
    public void setAge( int age )
    {
        myAge = age;
    }


    /**
     * The setter method for the gender of a person
     * @param gender the string that specifies the gender of the person
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}