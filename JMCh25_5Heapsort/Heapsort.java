/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Malavika Nair
 * @version March 8, 2020
 * 
 * @author Period - 1
 * @author Assignment - Heapsort
 * 
 * @author Sources - None
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    /**
     * Heapsort
     * 
     * @param a
     *            array to sort
     */
    public static void sort( double[] a )
    {
        int len = a.length;
        for ( int i = len / 2; i >= 1; i-- )
            reheapDown( a, i, len );
        while ( len > 1 )
        {
            double temp = a[0];
            a[0] = a[len - 1];
            a[len - 1] = temp;
            len--;
            reheapDown( a, 1, len );
        }
    }


    // Should be private - made public for testing
    /**
     * Reheap down method to be used in the heap sort
     * 
     * @param a
     *            array that reheap down
     * @param i
     *            index in array
     * @param n
     *            number to compare to
     */
    public static void reheapDown( double[] a, int i, int n )
    {
        int index = i - 1;

        while ( ( 2 * index ) + 1 < n )
        {
            if ( ( 2 * index ) + 2 == n )

                if ( a[index] > a[( 2 * index ) + 1] )
                    return;

                else
                {
                    double t = a[index];
                    a[index] = a[( 2 * index ) + 1];
                    a[( 2 * index ) + 1] = t;
                    return;
                }
            if ( a[( 2 * index ) + 1] < a[index]
                && a[( 2 * index ) + 2] < a[index] )
                return;
            else if ( a[( 2 * index ) + 1] > a[( 2 * index ) + 2] )
            {
                double t = a[index];
                a[index] = a[( 2 * index ) + 1];
                a[( 2 * index ) + 1] = t;
                index = ( 2 * index ) + 1;
            }
            else
            {

                double t = a[index];
                a[index] = a[( 2 * index ) + 2];
                a[( 2 * index ) + 2] = t;
                index = 2 * ( index + 2 );
            }
        }
    }

}
