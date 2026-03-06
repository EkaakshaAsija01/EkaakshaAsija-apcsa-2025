package polygon;

import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args) {
        drawBowtie();
        TestSuite.run();
    }

    // I deleted the myPolgon object for drawing and created my own bowtie shape for the purpose of the assignment.  
    public static void drawBowtie() {
        IrregularPolygon bow = new IrregularPolygon();

        bow.add(new Point2D.Double(0, 0));
        bow.add(new Point2D.Double(100, 100));
        bow.add(new Point2D.Double(0, 100));
        bow.add(new Point2D.Double(100, 0));

        bow.draw();
    }
}