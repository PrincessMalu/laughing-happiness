/**
 * Implements a sorted list of words
 * 
 * @author Malavika Nair
 * @version November 26, 2019
 * 
 * @author Period - 1st
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - None
 */
public class SortedWordList extends java.util.ArrayList<String>
{

    /**
     * no args constructor. Calls super and uses the parent classes constructor.
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * @param x
     *            size of the sorted word list
     */
    public SortedWordList( int x )
    {
        super( x );

    }


    /**
     * @param x
     *            object which is to be looked for in the sorted word list
     * @return true or false depending on whether the object is found or not.
     */
    public boolean contains( Object x )
    {
        int result = binarySearch( this, 0,  size() - 1, (String)x );
        return ( result != -1 );

    }


    /**
     * @param x
     *            object, of which the index is to be found
     * @return the index of the object
     */
    public int indexOf( Object x )
    {
        int result = binarySearch( this, 0, size() - 1, (String)x );
        return result;
    }


    /**
     * @param i
     *            index of the location to set
     * @param word
     *            word that is to replace the old word
     * @return the word that was originally in the index to be set.
     */
    public String set( int i, String word )
    {

        if ( i > 0 && i < size() - 1 )
        {

            if ( word.compareTo( get( i + 1 ) ) < 0
                && word.compareTo( get( i - 1 ) ) > 0
                && word.compareTo( get( i - 1 ) ) != 0
                && word.compareTo( get( i + 1 ) ) != 0 )
            {
                String ans = get( i );
                super.set( i, word );
                return ans;
            }
            else
            {
                throw new IllegalArgumentException(
                    "word =" + word + " i =" + i );
            }
        }
        else if ( i == 0 && word.compareTo( get( i + 1 ) ) != 0 )
        {
            int x = word.compareTo( get( i + 1 ) );
            if ( x < 0 )

            {
                String ans = get( i );
                super.set( i, word );
                return ans;
            }
            else
            {
                throw new IllegalArgumentException(
                    "word =" + word + " i =" + i );
            }
        }
        else if ( i == size() - 1 && word.compareTo( get( i - 1 ) ) != 0 )
        {
            int x = word.compareTo( get( i - 1 ) );
            if ( x > 0 )
            {
                String ans = get( i );
                super.set( i, word );
                return ans;
            }
            else
            {
                throw new IllegalArgumentException(
                    "word =" + word + " i =" + i );
            }
            // System.out.println(this);
            // System.out.println(super.set(i, word));

        }
        System.out.println( this );

        return null;
    }


    /**
     * @param i
     *            index of place to insert
     * @param word
     *            word that is to be added.
     */
    public void add( int i, String word )
    {
        if ( i != 0 && i < size() )
        {
            if ( word.compareTo( get( i - 1 ) ) > 0
                && word.compareTo( get( i + 1 ) ) < 0
                && word.compareTo( get( i - 1 ) ) != 0 )
            {
                super.add( i, word );
            }
            else
            {
                throw new IllegalArgumentException(
                    "word =" + word + " i =" + i );
            }
        }
        else if ( i == 0 )
        {
            if ( word.compareTo( get( i + 1 ) ) < 0
                && word.compareTo( get( i + 1 ) ) != 0 )
            {
                super.add( i, word );
            }
            else
            {
                throw new IllegalArgumentException(
                    "word =" + word + " i =" + i );
            }
        }
        else if ( i >= size() )
        {
            add( word );
        }
    }


    /**
     * (
     * 
     * @param word
     *            the string that is to be added to the list
     * @return true if the operation was successful, other false, if it already
     *         exists in the list.
     */
    public boolean add( String word )
    {
        int r = 0;
        int l = size();
        int mid;
        while ( r < l )
        {
            mid = ( r + l ) / 2;
            int x = word.compareToIgnoreCase( get( mid ) );
            if ( x > 0 )
            {
                r = mid + 1;
            }
            else if ( x < 0 )
            {
                l = mid;
            }
            else if ( x == 0 )
            {
                return false;

            }
        }
        super.add( l, word );
        return true;
    }


    /**
     * Takes two separate sorted Word lists and merges them into one big list.
     * 
     * @param x
     *            A sorted word List to merge the current one with
     */
    public void merge( SortedWordList x )
    {
        for ( String y : x )
        {
            add( y );
        }
    }


    /**
     * A method for binary searching called in other methods above
     * 
     * @param sortedWordList
     *            a sorted word list with which to binary search.
     * @param l
     *            the left most index
     * @param r
     *            the right most index
     * @param x
     *            the element to be searched for
     * @return the index of the element if found, otherwise -1.
     */
    public int binarySearch(
        SortedWordList sortedWordList,
        int l,
        int r,
        String x )
    {
        if ( r >= l )
        {
            int mid = l + ( r - l ) / 2;
            String var1 = get( mid );
//             System.out.println( mid + " " + var1 + " "+ x + " l: "+ l + " r:"
//             + r
//             +" cmp "+ var1.toLowerCase().compareTo(x.toLowerCase().trim()));

            if ( var1.toLowerCase().compareTo( x.toLowerCase().trim() ) == 0 )
            {
                return mid;
            }

            if ( var1.toLowerCase().compareTo( x.toLowerCase().trim() ) > 0 )
            {
                return binarySearch( this, l, ( mid - 1 ), x );
            }

            else
            {
                return binarySearch( this, ( mid + 1 ), r, x );
            }
        }

        return -1;
    }
}
