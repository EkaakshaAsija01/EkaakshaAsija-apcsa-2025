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
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
