
// Implements the list of messages for teletext

import java.awt.Graphics;


/**
 * The program keeps the headlines in a doubly-linked circular list. The list is
 * implemented in the TeletextList class. There are 10 methods with various
 * uses, like adding and removing nodes that contain messages, scrolling up and
 * drawing the headlines page.
 *
 * @author Malavika Nair
 * @version Jan 6, 2020
 * @author Period: 1
 * @author Assignment: JMCh20_7Teletext
 *
 * @author Sources: None
 */
public class TeletextList
{
    private ListNode2<String> heading;

    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        heading = new ListNode2<String>( "Today's headlines:", null, null );
        heading.setPrevious( new ListNode2<String>( " ", null, heading ) );
        heading.setNext( new ListNode2<String>( " ", heading, null ) );
        ListNode2<String> temp = heading.getNext();

        for ( String msg : headlines )
        {
            temp.setNext( new ListNode2<String>( msg, temp, null ) );
            temp = temp.getNext();
            // System.out.println(msg);
        }
        temp.setNext( heading.getPrevious() );
        heading.getPrevious().setPrevious( temp );

        topNode = heading;
    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        ListNode2<String> temp = heading.getNext().getNext();
        heading.getNext()
            .setNext( new ListNode2<String>( msg, heading.getNext(), temp ) );
        temp.setPrevious( heading.getNext().getNext() );
        System.out.println( heading );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        ListNode2<String> x = topNode.getNext();

        if ( x.equals( heading ) || x.equals( heading.getPrevious() )
            || x.equals( heading.getNext() ) )
        {
            return;
        }

        topNode = heading.getNext().getNext();

        ListNode2<String> temp = x.getNext();
        heading.getNext().setNext( temp );
        topNode.setPrevious( temp );
    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        this.topNode = topNode.getNext();
    }


    /**
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a reference to the added node.
     * 
     * @param node
     *            the node before which the new msg is added
     * @param msg
     *            the msg to be added with the new node
     * @return a reference to the added node. 
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        ListNode2<String> x = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getNext().setNext( x );
        node.setNext( x );
        return x;
    }


    /**
     * Removes a given node from the list.
     * 
     * @param node
     *            the node to remove
     */
    private void remove( ListNode2<String> node )
    {
        ListNode2<String> temp = heading;
        while ( temp != node )
        {
            temp = temp.getNext();
        }
        ListNode2<String> x = temp.getNext().getNext();
        temp.getPrevious().setNext( x );
        x.setPrevious( temp.getPrevious() );
    }


    /**
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * 
     * @param g
     *            graphics component in which the lines are drawn
     * @param x
     *            horizontally where the line is drawn
     * @param y
     *            is the height at which the line is drawn
     * @param lineHeight
     *            the space between the lines
     * @param nLines
     *            number of lines to draw
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node
            .getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
