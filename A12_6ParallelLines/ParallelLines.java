import java.awt.*;
import javax.swing.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Malavika Nair
 * @version September 24, 2019
 * 
 *          Period - 1st Period Assignment - A12.6 - ParallelLines
 * 
 *          Sources - None
 */
public class ParallelLines extends JPanel
{

    int iX = 15;

    int iY = 40;

    int offset = 20;

    int sideL = 40;


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * TODO Write your method description here.
     * 
     * @param g
     *            - graphics component
     * @param width
     *            - length of the window
     * @param height
     *            - height of the window
     * @param size
     *            - size of the window
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        for ( int row = 0; row < 8; row++ )
        {

            int x = iX;// calculate the start of the row of squares
            if ( row % 4 == 2 )
            {
                x = ( 2 * offset ) + iX;
            }
            else if ( row % 4 == 1 || row % 4 == 3 )
            {

                x = iX + offset;
            }
            else
            {
                x = iX;
            }

            for ( int col = 0; col < 7; col++ )
            {
                g.fillRect( x + (2 * col * sideL),
                    iY + ( row * sideL ),
                    sideL,
                    sideL );
            }

            g.drawLine( iX, row * sideL + 80, width - 60, row * sideL + 80 );
        }
    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
