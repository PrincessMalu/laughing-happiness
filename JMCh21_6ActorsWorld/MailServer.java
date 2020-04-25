import java.util.*;


/**
 * A class to send messages and add actors to the subscribed list of actors.
 * 
 * @author TODO Malavika Nair
 * @version TODO 23 January 2020
 * 
 * @author Period - 1
 * @author Assignment - JM Ch21.6 - Actors World
 * 
 * @author Sources - None
 */
public class MailServer extends LinkedList<Message>
{
    /**
     * Set to be defined
     */
    private Set<Actor> actors;


    /**
     * constructor
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();

    }


    /**
     * add actor to the group list
     * @param actor actor to be added
     */
    public void signUp( Actor actor )
    {
        actors.add( actor );
        System.out.println( actors );
    }


    /**
     * Sends the message out to the intended recipients
     * @param msg - message to be sent out
     */
    public void dispatch( Message msg )
    {
        {
            if ( msg.getRecipient() == null )
            {
                for ( Actor actor : actors )
                {
                    if ( !actor.equals( msg.getSender() ) )
                    {
                        actor.receive( msg );
                    }
                }
            }
            else
            {
                msg.getRecipient().receive( msg );
            }
        }
    }


    // for testing purposes only
    /**
     * gets actors
     * @return actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
