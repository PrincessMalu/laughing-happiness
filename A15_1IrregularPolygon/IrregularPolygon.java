
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;


/**
 * Class called irregular polygon, that finds the area of a polygon, draws the
 * polygon, calculates the distance between two points and finds the perimeter
 * of the polygon.
 *
 * @author Malavika nair
 * @version 11/7/2019
 *
 * @author Period - 1
 * @author Assignment - Irregular Polygon
 * 
 * @author Sources - None
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool( new SketchPad( 300, 300, 0 )
                            // );

    private ArrayList<Point2D.Double> myPolygon;


    // constuctors

    /**
     * Constructs the polygon, given an array of points
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    // public methods

    /**
     * Add the point to the polygon
     * @param aPoint a point to add
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * Calculates the distance between two points
     * 
     * @param p1
     *            point 1
     * @param p2
     *            point 2
     * @return the distance between them
     */
    public double dist( Point2D.Double p1, Point2D.Double p2 )
    {
        double d1 = p2.x - p1.x;
        double d2 = p2.y - p1.y;
        double d = ( d1 * d1 ) + ( d2 * d2 );
        double dist = Math.sqrt( d );
        return dist;
    }


    /**
     * Calculates the perimeter
     * 
     * @return perimeter of the polygon
     */
    public double perimeter()
    {
        if ( myPolygon.isEmpty() )
        {
            return 0;
        }
        double perimeter = 0;
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            perimeter += dist( myPolygon.get( i ), myPolygon.get( i + 1 ) );
        }
        perimeter = perimeter + dist( myPolygon.get( myPolygon.size() - 1 ),
            myPolygon.get( 0 ) );
        return perimeter;
    }


    /**
     * Calculates the area
     * 
     * @return area
     */
    public double area()
    {
        double area = 0;
        for ( int k = 0; k < myPolygon.size(); k++ )
        {
            area += +myPolygon.get( k ).getX()
                * myPolygon.get( ( k + 1 ) % myPolygon.size() ).getY();
            area -= +myPolygon.get( k ).getY()
                * myPolygon.get( ( k + 1 ) % myPolygon.size() ).getX();
        }
        area = Math.abs( area ) / 2.0;
        return area;
    }


    /**
     * draws the polygon.
     */
    public void draw()
    {
        if ( myPolygon.size() < 3 )
        {
            return;
        }
        pen.up();
        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
        pen.down();
        for ( int i = 1; i < myPolygon.size(); i++ )
        {
            pen.move( myPolygon.get( i ).getX(), myPolygon.get( i ).getY() );
        }
        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
    }
}
