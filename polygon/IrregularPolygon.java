package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor// for commit
    public IrregularPolygon() {}
  
    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);// TODO: Add a point to the IrregularPolygon.
    }
  
    public double perimeter() {
        double total = 0.0;
        for (int i = 0; i < myPolygon.size() - 1; i++) {
            Point2D.Double p1 = myPolygon.get(i); //find the distance between point and next point and add to total.
            Point2D.Double p2 = myPolygon.get(i + 1);
            total += p1.distance(p2);
            } //I didn't like the old method I used of using module to bring everything connect the first and last points to finish the shape.
        Point2D.Double first = myPolygon.get(0); // I hardcoded the final side to be added into the perimeter. My forloop using modulo didn't work
        Point2D.Double last = myPolygon.get(myPolygon.size() - 1);
        total += last.distance(first);

        return total;
       

    }
    public double area() {
        double total = 0.0;

        // Add products for consecutive points
        for (int i = 0; i < myPolygon.size() - 1; i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get(i + 1);
            total += (p1.x * p2.y) - (p1.y * p2.x);
        } // This is the shoelace formula we learned about in class. I used a similar approach as the perimeter but instead I used area formula.

        // Add last point connected to first. Similar to perimeter, I hardcoded it to avoid forloop confusion.
        Point2D.Double first = myPolygon.get(0);
        Point2D.Double last = myPolygon.get(myPolygon.size() - 1);

        total += (last.x * first.y) - (last.y * first.x);

        return Math.abs(total) / 2.0;
    }

   public void draw()
{
    try {
        if (myPolygon.isEmpty()) {
            System.out.println("No points to draw.");
            return;
        }

        // baseline from first point
        Point2D.Double firstPt = myPolygon.get(0);
        double maxX = firstPt.getX();
        double maxY = firstPt.getY();
        double minX = firstPt.getX();
        double minY = firstPt.getY();

        // loop 1 – compute extents
        for (int i = 1; i < myPolygon.size(); i++) {
            double x = myPolygon.get(i).getX();
            double y = myPolygon.get(i).getY();
            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;
            if (x < minX) minX = x;
            if (y < minY) minY = y;
        }

        int width  = (int) (maxX + 50);
        int height = (int) (maxY + 50);
        if (width  < 300) width  = 300;
        if (height < 300) height = 300;

        DrawingTool pen = new DrawingTool(new SketchPad(width, height));
        double pad = 25; // keep the shape off the edge

        // move to starting point
        pen.up();
        pen.move(firstPt.getX() - minX + pad, firstPt.getY() - minY + pad);
        pen.down();

        // loop 2 – draw by moving
        for (int i = 1; i < myPolygon.size(); i++) {
            double x = myPolygon.get(i).getX();
            double y = myPolygon.get(i).getY();
            pen.move(x - minX + pad, y - minY + pad);
        }
        // close polygon
        pen.move(firstPt.getX() - minX + pad, firstPt.getY() - minY + pad);

    } catch (java.awt.HeadlessException e) {
        System.out.println("Exception: No graphics support available.");
    }
}

}
