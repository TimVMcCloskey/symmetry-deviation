import java.util.*;

//***************************************************
//
//  Circle
//
//  Holds center, radius, degree increments of spokes,
//  and spoke end points of circle
//
//****************************************************

public class Circle {
    public Point center;
    public double radius;
    public double degree;
    public ArrayList<Point> spokePoints;
     
    public Circle() {
        this.center = new Point();
        this.radius = 0.0;
    }
    
    public Circle(Point c, double r) {
        this.center = c;
        this.radius = r;
    }
    
    // Fill spokePoints ArrayList with end point coordinates at deg intervals
    void getSpokes(double deg) {
        degree = deg;
        Transformation transform = new Transformation();
        spokePoints = new ArrayList<Point>();
        double tick = 0.0;
        Point point;
        Point firstPoint = new Point(radius,0.0);
        
        
        while( tick < 360.0) {
            transform.identity();
            transform.rotate(-tick);
            transform.translate(center.x,center.y);
            point = firstPoint;
            spokePoints.add(transform.doTransformation(point));
            tick += degree;
        }
    }
}

