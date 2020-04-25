import java.util.*;


/**
 * RPN Calculator
 *
 * @author Malavika Nair
 * @version januay 14, 2020
 * @author Period: 1
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources:None
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * takes the inputed function and decides what to do.
     */
    public void calculate()
    {
        while ( scan.hasNext() )
        {
            String str = scan.next();
            int count = 0;
            while ( count < str.length() )
            {

                char c = str.charAt( count );
                if ( !( c == 'Q' ) && !( c == 'q' ) )
                {
                    myQ.add( c + "" );
                }

                if ( c == 'Q' || c == 'q' )
                {
                    System.out
                        .println( returnString() + "= " + myStack.pop() );
                }
                else if ( c == '+' )
                {
                    add();
                }
                else if ( c == '-' )
                {
                    subtract();
                }
                else if ( c == '*' )
                {
                    multiply();
                }
                else if ( c == '/' )
                {
                    divide();
                }
                else
                {
                    myStack.push( Character.getNumericValue( c ) );
                }

                count++;
            }
        }

    }


    /**
     * add
     */
    public void add()
    {
        myStack.push( myStack.pop() + myStack.pop() );
    }


    /**
     * subtract
     */
    public void subtract()
    {

        myStack.push( -myStack.pop() + myStack.pop() );
    }


    /**
     * multiply
     */
    public void multiply()
    {
        myStack.push( myStack.pop() * myStack.pop() );
    }


    /**
     * divide
     */
    public void divide()
    {
        int first = myStack.pop();
        int second = myStack.pop();
        myStack.push( second / first );
    }


    /**
     * turns the Queue into a string
     * 
     * @return result the result of the myQ
     */
    public String returnString()
    {
        String print = "";
        while ( !myQ.isEmpty() )
        {
            print += myQ.remove() + " ";
        }
        return print;
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}