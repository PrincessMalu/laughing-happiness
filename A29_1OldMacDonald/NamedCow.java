/**
 * Named Cow class, that gives the objects of a cow class a name. The named cow
 * class, extends the Cow class and has 2 constructors. One of the constructors
 * is the same as he super class's constructors. The other adds a field for the
 * name of the cow.
 *
 * @author Malavika Nair
 * @version Oct 29, 2019
 * @author 1st
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
class NamedCow extends Cow
{
    private String myName;


    /**
     * @param type what type of farm animal is it
     * @param name what is the name of the cow
     * @param sound what sound does this animal make
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        myName = name;
    }


    /**
     * @param type what type of farm animal is it
     * @param sound what sound does this animal make
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     *  A getter method for the myName field of the Named cow Class. 
     * @return the name of the cow
     */
    public String getName()
    {
        return myName;
    }

}
