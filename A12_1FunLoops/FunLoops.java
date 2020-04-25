/**
 * A class to solve various loop problems
 * 
 * @author Malavika Nair
 * @version September 19, 2019
 * 
 *          Period - 1nd period Assignment - A12.1 - FunLoops
 * 
 *          Sources - None
 */
public class FunLoops
{
    /**
     * prints out the first n magic squares
     * 
     * @param n
     *            number of magic square that are to be found.
     */
    public void magicsquare( int n )
    {
        System.out.println( "Magic Squares" );
        int count = 0;
        long sum = 0;
        long magic = 1;
        long square = 0;
        long sI = 1;
        int sumI = 1;

        while ( count < n )
        {
            square = sI * sI;
            while ( square > sum )
            {
                sum = sum + sumI;
                sumI += 1;
                if ( square == sum )
                {
                    break;
                }

            }

            while ( square < sum )
            {
                sI++;
                square = sI * sI;
                if ( square == sum )
                {
                    break;
                }

            }
            if ( square == sum )
            {
                magic = sum;
                sI++;
                count++;
                System.out.println( magic );
            }

        }
    }


    /**
     * Calculates the lcm (least common multiple) of a 2 numbers given two
     * integers a and b
     * 
     * @param a
     *            one integer of which the lcm is found
     * @param b
     *            other integer of which the lcm is found
     * @return returns integer the lcm of both numbers
     */
    public int lcm( int a, int b )
    {

        int gcf = 1;
        int y = b;
        int x = a;

        while ( a != b )
        {
            if ( a < b )
            {
                b = b - a;
            }
            else
            {
                a = a - b;
            }
            gcf = a;

        }
        int lcm = ( x * y ) / gcf;
        return lcm;

    }


    /**
     * main method, with with the code and methods written above are called.
     * 
     * @param args
     *            string array
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );

        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
