/**
 * The Chick class, that is one type of Animal The Chick class implements the
 * animal interface, and creates and object of Chick type. The class has 2
 * constructors and one of its constructor has 2 parameters. The parameters are
 * the sound the Pig makes and the type of animal. The other constructor has
 * three parameters, the type of animal and 2 different sounds that the animal
 * could possibly make.
 *
 * @author Malavika Nair
 * @version Oct 29, 2019
 * @author Period: 1st
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
class Chick implements Animal
{
    private String myType;

    private String mySound;

    private String sound;


    /**
     * @param type
     *            the type of animal
     * @param sound
     *            the sound that the animal makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * @param type
     *            the type of the animal
     * @param s1
     *            the first type of sound
     * @param s2
     *            the second type of sound
     */
    public Chick( String type, String s1, String s2 )
    {
        myType = type;
        mySound = s1;
        sound = s2;
    }


    /**
     * A getter method that gets the type of animal
     * 
     * @return the type of the animal.
     */
    public String getType()
    {
        return myType;
    }


    @Override
    public String getSound()
    {
        double num = Math.random();
        if ( sound != null )
        {
            if ( num > 0.5 )
            {
                return sound;
            }
            else
            {
                return mySound;
            }

        }
        else
        {
            return mySound;
        }
    }

}