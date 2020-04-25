


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Malavika Nair 
 * @version February 13 2020
 * 
 * @author Period - 1
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - TODO list collaborators
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * @param numLetters the number of letters
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * set substitution
     * @param index position in lookup table
     * @param ch chaacter to set as there
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    /**
     * decodes the code
     * @param text txt to decode
     * @return the string after its decoded
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        char character;
        int i = 0;

        for ( int index = 0; index < text.length(); index++ )
        {
            character = text.charAt( index );

            if ( Character.isLowerCase( character ) )
            {
                i = Character.getNumericValue( text.charAt( index ) )
                    - Character.getNumericValue( 'a' );
                buffer.append( ( "" + lookupTable[i] ).toLowerCase() );
            }
            else if ( Character.isUpperCase( character ) )
            {
                i = Character.getNumericValue( text.charAt( index ) )
                    - Character.getNumericValue( 'A' );
                buffer.append( ( "" + lookupTable[i] ).toUpperCase() );
            }
            else
            {
                buffer.append( character );
            }

        }
        return buffer.toString();

    }


    /**
     * gets what the code might be after its encoded
     * @param text to analyze
     * @param lettersByFrequency what letters should be after frequency analysis
     * @return what the code might be
     */
    public String getHints( String text, String lettersByFrequency )
    {
        String hints = "";

        int[] counts = countLetters( text );
        int rank;

        for ( int k = 0; k < counts.length; k++ )
        {
            rank = 0;

            for ( int i = 0; i < counts.length; i++ )
            {
                if ( counts[i] < counts[k] || counts[i] == counts[k] && i < k )
                {
                    rank++;
                }
            }
            hints += lettersByFrequency.charAt( rank );
        }
        return hints;
    }


    /**
     * counts letters in text
     * @param text text to count letters from
     * @return the frequency of letters
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( char c : text.toCharArray() )
        {
            if ( c >= 'A' && c <= 'Z' )
            {
                counts[c - 'A']++;

            }
            else if ( c >= 'a' && c <= 'z' )
            {
                counts[c - 'a']++;
            }
        }

        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * get the look up table
     * @return the look up table
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     *  gets count letter
     * @param text to count letter from
     * @return count letters
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}