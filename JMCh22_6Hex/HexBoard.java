/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Malavika Nair
 * @version 26 January 2020
 * 
 * @author Period - 1
 * @author Assignment - JM Ch22.6 - Hex
 * 
 * @author Sources - None
 */
public class HexBoard extends CharMatrix
{
    /**
     * @param rows
     *            number of rows
     * @param cols
     *            number of columns
     */
    public HexBoard( int rows, int cols )
    {
        super( rows, cols );

    }


    /**
     * Checks if a square is black
     * 
     * @param r
     *            x - coordinate
     * @param c
     *            y - coordinate
     * @return if square is black
     */
    public boolean isBlack( int r, int c )
    {
        if ( isInBounds( r, c ) && charAt( r, c ) == 'b' )
        {
            return true;
        }
        return false;
    }


    /**
     * Checks if a square is White
     * 
     * @param r
     *            x - coordinate
     * @param c
     *            y - coordinate
     * @return if square is White
     */
    public boolean isWhite( int r, int c )
    {
        if ( isInBounds( r, c ) && charAt( r, c ) == 'w' )
        {
            return true;
        }
        return false;
    }


    /**
     * Checks if a square is grey
     * 
     * @param r
     *            x - coordinate
     * @param c
     *            y - coordinate
     * @return if square is grey
     */
    public boolean isGray( int r, int c )
    {
        if ( isInBounds( r, c ) && charAt( r, c ) == 'x' )
        {
            return true;
        }
        return false;
    }


    /**
     * setBlack method - makes the square Black
     * 
     * @paramsetWhite method - makes the square white
     */
    public void setBlack( int r, int c )
    {
        setCharAt( r, c, 'b' );
    }


    /**
     * setWhite method - makes the square white
     * 
     * @param r
     *            x - coordinate
     * @param c
     *            y - coordinate
     */
    public void setWhite( int r, int c )
    {
        setCharAt( r, c, 'w' );
    }


    /**
     * setGray method - makes the square Grey
     * 
     * @param r
     *            x - coordinate
     * @param c
     *            y - coordinate
     */
    public void setGray( int r, int c )
    {
        setCharAt( r, c, 'x' );
    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        int countt = 0;
        for ( int i = 0; i < numRows(); i++ )
        {
            areaFill( i, 0 );
        }
        for ( int i = 0; i < numRows(); i++ )
        {
            if ( isGray( i, numCols() - 1 ) )
            {
                countt++;
            }
        }
        for ( int i = 0; i < numRows(); i++ )
        {
            for ( int k = 0; k < numCols(); k++ )
            {
                if ( isGray( i, k ) )
                {
                    setBlack( i, k );
                }
            }
        }
        return countt > 0;
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     * 
     * @param r
     *            row to fill
     * @param c
     *            column to fill
     */
    public void areaFill( int r, int c )
    {
        if ( isInBounds( r, c ) && isBlack( r, c ) )
        {
            setGray( r, c );
            areaFill( r - 1, c - 1 );
            areaFill( r - 1, c );
            areaFill( r, c - 1 );
            areaFill( r, c + 1 );
            areaFill( r + 1, c );
            areaFill( r + 1, c + 1 );
        }
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        String s = "";

        for ( int r = 0; r < numRows(); r++ )
        {
            for ( int c = 0; c < numCols(); c++ )
            {
                if ( isBlack( r, c ) )
                    s += 'B';
                else if ( isWhite( r, c ) )
                    s += 'W';
                else if ( isGray( r, c ) )
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }


    // ****************************************************************

    private boolean isInBounds( int row, int col )
    {
        if ( row >= 0 && row < numRows() && col >= 0 && col < numCols() )
        {
            return true;
        }
        return false;
    }
}
