import java.util.NoSuchElementException;

/**
 *  Implements a singly-linked list with a tail.
 *
 *  @author  Malavika Nair
 *  @version DEcember 12, 2019
 *  @author  Period: 1st
 *  @author  Assignment: JMCh20_5LinkedListWithTail
 *
 *  @author  Sources: none
 */
public class LinkedListWithTail<E>
{
    private ListNode<E> head, tail;

    /**
     * Constructs an empty list.
     */
    public LinkedListWithTail()
    {
        head = null;
        tail = null;
    }

    /** 
     * Returns true if this list is empty; otherwise returns false.
     * 
     * @return true if this list contains no elements false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * 
     * @return the head of this list, or null if this list is empty
     */
    public E peek()
    {
        if(isEmpty())
        {
            return null;
        }
        else {
           E x = head.getValue();
            return x;
        }
                        
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param obj - element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    public boolean add(E obj)
    {
        if(isEmpty())
        {
            head = new ListNode<E>(obj,tail);
            tail = head;
            return true;
        }
        else if (isEmpty() == false)
        {
            ListNode<E> a = new ListNode<E>(obj,null); 
            tail.setNext( a );
            tail = a;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * 
     * @return the head of this list
     * @throws NoSuchElementException - if this list is empty
     */
    public E remove() throws NoSuchElementException
    {
        if( isEmpty() )
        {
            throw new NoSuchElementException();      
        }
        E result = head.getValue();
        head = head.getNext();
        return result;
    }
    
    /**
     * Exercise 20.12
     * 
     * Appends otherList at the end of this list.
     * Append should work in O(1) time, regardless of the list sizes, and
     * it should work properly when either list is empty or both list are empty
     * 
     * @param otherList list to be appended to the end of this list
     */
    public void append( LinkedListWithTail<E> otherList )
    {
        if (isEmpty())
        {
            head = otherList.head;
        }
        else if ( !( otherList == null ) )
        {
            tail.setNext( otherList.head );
        }
    }
    
    /**   *** FOR TESTING PURPOSES ONLY ***
     *
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String str = "[", separator = "";

        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}

