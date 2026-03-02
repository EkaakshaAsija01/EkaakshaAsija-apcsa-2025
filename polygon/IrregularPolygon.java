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
        // TODO: Add a point to the IrregularPolygon.
    }

     public double perimeter() {
        // TODO: Calculate the perimeter.

        // If there are fewer than 2 points, there is no perimeter
        if (myPolygon.size() < 2) {
            return 0;
        }

        double total = 0;

        // Loop through each point in the polygon
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);

            // For the last point, connect it back to the first point
            Point2D.Double next;
            if (i == myPolygon.size() - 1) {
                next = myPolygon.get(0); // connect last point to first
            } else {
                next = myPolygon.get(i + 1);
            }

            // Calculate distance between current point and next point
            double distX = next.x - current.x;
            double distY = next.y - current.y;
            total += Math.sqrt(distX * distX + distY * distY);
        }

        return total;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        return area;
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
