import java.util.Scanner;
import java.io.*;


/**
 * Takes a given text file of words, and creates an output files taking out any
 * words in the original file that don't fit the criteria for the new one. Makes
 * a list of words that are the same length as the minlength or larger, but are
 * also smaller than the maxlength.
 * 
 * @author Malavika Nair
 * @version November 19, 2019
 * 
 * @author Period - 1st
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 * @author Sources - None
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out
                .println( "*** Can't create RamblecsDictionary.java ***" );
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     * 
     * @throws FileNotFoundException
     */
    public static void openInputFile( String fileName )
        throws FileNotFoundException
    {
        fileIn = new Scanner( new File( fileName ) );
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     * 
     * @throws FileNotFoundException
     */
    public static void createOutputFile( String fileName )
        throws FileNotFoundException
    {
        fileOut = new PrintWriter( new File( fileName ) );
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {

        fileOut.println( " public class RamblecsDictionary " );
        fileOut.println( " {" );
        fileOut.println( " public String words [] = " );
        fileOut.println( "  { " );
        int index = 0;
        while ( fileIn.hasNext() )
        {
            String str = fileIn.next();
            if ( str.length() >= MINLENGTH && str.length() <= MAXLENGTH )
            {
                str = str.toUpperCase();
                fileOut.println( "      \"" + str + "\"," );
                index++;
            }

        }
        fileOut.println( "   };" );
        fileOut.println( "}" );
        return index;

    }
}
