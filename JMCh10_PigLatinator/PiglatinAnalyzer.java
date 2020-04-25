import java.util.Scanner;


/**
 * Translate a given text into pig Latin. The following code takes any given
 * text of English words and translates them into pig Latin with the rules that
 * follow below. It returns the translated text back to the user. There are 4
 * methods in the class. One translates the entire text, another translates
 * every word. The third finds the first occurrence of a vowel in the word. And
 * the last decides whether the string has vowel or not.
 * 
 * @author Malavika Nair
 * @version October 16, 2019
 * 
 * @author Period - 1st Period
 * @author Assignment - Piglatinator
 * 
 * @author Sources - None
 */
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        int begin = 0;
        int end = 0;
        while ( begin < phraseToTranslate.length() )
        {
            if ( Character.isLetter( phraseToTranslate.charAt( begin ) ) )
            {
                for ( end = begin; end < phraseToTranslate.length(); end++ )
                {
                    if ( !Character
                        .isLetter( phraseToTranslate.charAt( end ) ) )
                    {
                        break;
                    }
                }
                String englishWord = phraseToTranslate.substring( begin, end );
                translation = translation + wordToPigLatin( englishWord );
                begin = end;
            }
            else
            {
                translation += phraseToTranslate.charAt( begin );
                begin++;
            }
        }
        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        if ( hasVowel( englishWord ) == false )
        {
            pigLatinWord = englishWord + "ay";
            return pigLatinWord;
        }
        else if ( vLoc( englishWord ) == 0 )
        {
            pigLatinWord = englishWord + "yay";
            return pigLatinWord;
        }
        else
        {
            String start = englishWord.substring( 0, vLoc( englishWord ) );
            String end = englishWord.substring( vLoc( englishWord ),
                englishWord.length() );
            // 3. But, if englishWord is capitalized, then capitalize end an
            // "uncapitalize" start.
            if ( start.length() > 0
                && Character.isUpperCase( start.charAt( 0 ) ) )
            {
                start = start.toLowerCase();
                String firstCE = end.substring( 0, 1 );
                firstCE = firstCE.toUpperCase();
                end = end.substring( 1, end.length() );
                end = firstCE + end;
            }
            pigLatinWord = end + start + "ay";

        }

        return pigLatinWord;
    }


    /**
     * Given a string or test, the method returns the location of the first
     * occurrence of a vowel.
     * 
     * @param string
     *            a string of text(word)
     * @return an integer position of the the first occurrence of a vowel in a
     *         String
     */
    public int vLoc( String string )
    {
        int ans = -1;
        for ( int i = 0; i < string.length(); i++ )
        {
            if ( string.charAt( i ) == 'a' || string.charAt( i ) == 'A'
                || string.charAt( i ) == 'e' || string.charAt( i ) == 'E'
                || string.charAt( i ) == 'i' || string.charAt( i ) == 'I'
                || string.charAt( i ) == 'o' || string.charAt( i ) == 'O'
                || string.charAt( i ) == 'u' || string.charAt( i ) == 'U' )
            {
                ans = i;
                break;
            }
        }
        return ans;
    }


    /**
     * Takes a string of text and analyzes to see if the given string has a
     * vowel or not.
     * 
     * @param string
     *            a string of text(word)
     * @return true or false depending on whether or not the string as a vowel
     */
    public boolean hasVowel( String string )
    {
        string = string.toLowerCase();
        if ( ( string.contains( "a" ) || string.contains( "e" )
            || string.contains( "i" ) || string.contains( "o" )
            || string.contains( "u" ) ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
