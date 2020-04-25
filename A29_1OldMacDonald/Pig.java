/**
 * The Pig class, that is one type of Animal The Pig class implements the animal
 * interface, and creates and object of Pig type. The class has 1 constructor
 * and its constructor has 2 parameters. The parameters are the sound the Pig
 * makes and the type of animal.
 *
 * @author Malavika Nair
 * @version Oct 29, 2019
 * @author Period: 1st
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
class Pig implements Animal
{

    private String myType;

    private String mySound;


    /**
     * @param type
     *            what type of animal is it
     * @param sound
     *            what sound does the animal make
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


   /** 
    * a getter method for the sound field
    * @return the sound of the animal
    */
    public String getSound()
    {
        return mySound;
    }


   /** 
    * a getter method for the type field
    * @return the type of animal
    */
    public String getType()
    {
        return myType;
    }
}
