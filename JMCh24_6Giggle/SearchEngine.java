import java.util.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Malavika Nair
 * @version 2/24/2020
 * 
 * @author Period - 1
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - None
 */
public class SearchEngine
{
    // Instance variable(s)
    /**
     * holds the name for the "url" (file name)
     */
    private String myURL; //

    /**
     * holds the word index
     */
    private Map<String, List<String>> myIndex; //


    // Constructor(s)
    /**
     * @param url
     *            url to save
     */
    public SearchEngine( String url )
    {
        myURL = url;
        myIndex = new HashMap( 20000 );
    }


    // Methods
    /**
     * Returns myUrl.
     * 
     * @return myURL
     */
    public String getURL()
    {
        return myURL;

    }


    /**
     * Extracts all words from line, and, for each word, adds line to its list
     * of lines in myIndex.
     * 
     * @param line
     *            line to extract words from
     */
    public void add( String line )
    {
        Set<String> list = parseWords( line );
        for ( String string : list )
        {
            LinkedList<String> temp = new LinkedList<String>();
            if ( !myIndex.containsKey( string ) )
            {
                myIndex.put( string, temp );
            }
            myIndex.get( string ).add( line );
        }
    }


    /**
     * Returns the list of lines associated with word in myIndex.
     * 
     * @param word
     *            word to look for
     * @return list of lines associated with word.
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * Returns a set of all words in line.
     * 
     * @param line
     *            line to get words from
     * @return all the words in line
     */
    private Set<String> parseWords( String line )
    {
        String[] words = line.split( "\\W+" );
        TreeSet<String> w = new TreeSet<String>();
        for ( String str : words )
        {
            if ( !str.isEmpty() )
            {
                str = str.toLowerCase();
                w.add( str );
            }
        }
        return w;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * gets index
     * @return index
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
