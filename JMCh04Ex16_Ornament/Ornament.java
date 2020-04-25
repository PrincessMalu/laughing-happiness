import java.awt.*;
import javax.swing.*;


/**
 * This program draws an ornament of nested triangles
 * 
 * @author Malavika Nair
 * @version September 17, 2019
 * 
 * @author Period - 1
 * @author Assignment - Ch04 Ex4-16 Ornament
 * 
 * @author Sources - None
 */
public class Ornament extends JPanel
{
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }


    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r
     * 
     * @param g
     *            is a graphics component
     * @param x
     *            X is the X midpoint of the biggest triangle
     * @param y
     *            Y is the heights of the biggest triangle
     * @param r
     *            is the half length of the base of the biggest triangle.
     */

    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        // TODO your code goes here  
        g.drawLine( x + r, y, x, y - r );
        g.drawLine( x - r, y, x + r, y );
        g.drawLine( x - r, y, x, y - r );
        if ( r == 4 )
        {
            return;
        }
        else
        {
            drawTriangles( g, x + r / 2, y, r / 2 );
            drawTriangles( g, x - r / 2, y, r / 2 );
            

        }

    }


    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}