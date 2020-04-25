/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Malavika Nair
 * @version September 24, 2019
 * @author 1st Period
 * @author Assignment: JMCh08_PerfectNumbers
 *
 * @author Sources: None
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param num
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( long num )
    {
        if ( num <= 1 )
            return false;

        int m = 2;

        while ( m * m <= num )
        {
            if ( num % m == 0 )
                return false;
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     * // Returns the n-th Fibonacci number. // Precondition: n >= 1 public
     * static long fibonacci(int n) { if (n == 1 || n == 2) return 1; else
     * return fibonacci(n - 1) + fibonacci(n - 2); } Rewrite it without
     * recursion, using one loop.
     *
     * @param n
     *            Fibonacci number to find
     * @return n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        int f1 = 0;
        int f2 = 1;

        for ( int i = 0; i < n; i++ )
        {
            int num = f1;
            f1 = f2;
            f2 += num;
        }
        return f1;
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n
     *            number to test
     * @return true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {
        {
            int sum = 0;
            for ( int k = 1; k < n; k++ )
            {
                if ( n % k == 0 )
                {
                    sum += k;
                }
            }
            return sum == n;
        }

    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n
     *            number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n
     *            number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        int count = 0;

        for ( int j = 2; count < 6; j++ )
        {
            long num = (int)Math.pow( 2, j ) - 1;
            if ( isPrime( num ) )
            {
                System.out.println( num );
                count++;
            }
        }

        System.out.println();
    }


    /**
     * Prints the first n even perfect numbers
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int i = 1;
        int count = 1;
        long p;
        while ( count <= n )// have to start count at zero
        {
            p = (int)Math.pow( 2, i ) - 1;
            long pN = p * (int)Math.pow( 2, i - 1 );
            if ( isPrime( p ) )
            {
                System.out.println( pN );
                count++;
            }
            i++;
        }

    }


    /*********************************************************************/

    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
 * 19-th Fibonacci number = 4181 Perfect numbers: 6 28 496 8128 Mersenne primes:
 * 3 7 31 127 8191 131071 524287 Even perfect numbers: 6 28 496 8128 33550336
 * 8589869056 137438691328
 */