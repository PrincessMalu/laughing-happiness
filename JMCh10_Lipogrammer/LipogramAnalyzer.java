/**
 * This class takes all words with an e and replaces the e with a pound sign It
 * looks though string text for a specific letter e and replaces every instance
 * of it with a pound sign. It then takes all the "offending words and
 * concatenates them into one list.
 * 
 * @author Malavika Nair
 * @version October 7, 2019
 * 
 * @author Period - 1st
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - None
 */
public class LipogramAnalyzer
{
    /**
     * Is a field that saves the String text.
     */
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {

        String specialLetter = "";
        int len = text.length();
        for ( int i = 0; i < len; i++ )
        {
            char c = text.charAt( i );
            if ( c == letter )
            {

                specialLetter = specialLetter + '#';
            }
            else
            {
                specialLetter = specialLetter + text.charAt( i );
            }
        }
        return specialLetter;

    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String ans = "";

        boolean let1 = false;

        for ( int i = 0; i <= text.length() - 1; i++ )

        {

            if ( text.charAt( i ) == letter )
            {
                String specialWord = this.extractWord( i );
                if ( ans.indexOf( specialWord ) == -1 )
                {

                    if ( specialWord.length() > 1 )
                    {
                        ans += specialWord.trim() + "\n"; //

                    }
                    else if ( specialWord.length() == 1 && !let1 )
                    {
                        ans += specialWord.trim() + "\n"; //
                        let1 = true;

                    }

                }
                else if ( specialWord.length() == 1 && !let1 )
                {
                    ans += specialWord + "\n";
                    let1 = true;
                }

            }

        }

        return ans;
    }


    // made public for test purposes
    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        char c = text.charAt( pos );
        if ( pos == 0 )// very first letter
        {
            if ( text.length() == 1 )
            {
                return text;
            }
            int beg = 0;
            int i = text.indexOf( ' ', beg ); // find end of word
            String str = text.substring( 0, i ); // print out the word
            return str;

        }
        if ( pos == text.length() - 1 ) // the very end
        {
            String str = "";
            if ( Character.isLetter( c ) )
            {
                int i = text.lastIndexOf( ' ', pos );
                if ( Character.isLetter( text.charAt( pos ) ) )
                {
                    str = text.substring( i + 1, text.length() );

                }
                else
                {
                    str = text.substring( i, text.length() - 1 );

                }

                return str;
            }
            else
            {
                str = "";
                return str;

            }
        }

        else
        {
            int start = pos;
            int end = pos;
            while ( end < text.length() - 1
                && Character.isLetter( text.charAt( end ) ) )
            {
                end++;
            }

            while ( start >= 0 && Character.isLetter( text.charAt( start ) ) )
            {
                start--;
            }

            String str = text.substring( start + 1, end );
            return str;

        }
    }
}
