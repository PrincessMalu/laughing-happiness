
import java.util.Stack;


/**
 * Bowser view lass, that has methods that are called in the other classes.
 * there are methods to go forward, back, home and to the top line. It also
 * contains method to check if there is a possibility to go back and forward.
 *
 * @author Malavika Nair
 * @version Jan 21, 2020
 * @author Period: 1
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: None
 */
public class BrowserModel
{
    /**
     * screen
     */
    private BrowserView view;

    /**
     * stack for forward
     */
    private Stack<Integer> forwardStk;
    /**
     * stack for back 
     */
    private Stack<Integer> backStk;
    /**
     * the top line
     */
    private int topLine;


    /**
     * @param view1 a browser view
     */
    public BrowserModel( BrowserView view1 )
    {
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        view = view1;
        view.update( 0 );
    }


    /**
     * checks if the back Stack is empty
     * 
     * @return true if stack is not empty
     */
    public boolean hasBack()
    {
        return !backStk.empty();
    }


    /**
     * checks if the forward Stack is empty
     * 
     * @return true if stack is not empty

     */
    public boolean hasForward()
    {
        return !forwardStk.empty();
    }


    /**
     * goes back like a bowser would
     */
    public void back()
    {
        Integer n = new Integer( topLine );
        forwardStk.push( n );

       // System.out.println( "backA: " + topLine );
        if ( hasBack() )
        {

            int num = backStk.pop().intValue();
            topLine = num;
        }
        view.update( topLine );
        //System.out.println( "backB: " + topLine );
    }


    /**
     * goes forward like a browser would
     */
    public void forward()
    {

        Integer count = new Integer( topLine );
        backStk.push( count );
        if ( hasForward() )
        {

            int num = forwardStk.pop().intValue();
            topLine = num;
            view.update( topLine );
        }
    }


    /**
     * goes "home"
     */
    public void home()
    {
        Integer num = new Integer( topLine );
        backStk.push( num );

        topLine = 0;
        view.update( topLine );
        forwardStk.removeAllElements();

    }


    /**
     * follows the link
     * 
     * @param count "the link" to follow
     */
    public void followLink( int count )
    {
        Integer num = new Integer( topLine );
        backStk.push( num );

        topLine = count;
        view.update( topLine );
        forwardStk.removeAllElements();

    }


    // The following are for test purposes only
    /**
     * getter method for the back stack
     * @return the back stack
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * getter method for the forward stack
     * @return the forward stack
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * getter method for topLine
     * @return integer with topline
     */
    public int getTopLine()
    {
        return topLine;
    }
}
