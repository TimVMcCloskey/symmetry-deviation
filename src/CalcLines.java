
/**
 * 
 *  Basic calculations on lines
 *   
 */

public class CalcLines {
    
    double length(Line line) {
        double x = line.p2.x - line.p1.x;
        double y = line.p2.y - line.p1.y;
        
        return Math.sqrt( (x * x) + (y * y) );        
    }
    
    
    
    //
    //
    // Get intersection of 2 lines using cross product method
    //
    // returns point(0.0 , 0.0) if no  intersection
    //
    //
    
    Point intersection(Line line1, Line line2) {
        Point point;
        double x1 = line1.p1.x;
        double y1 = line1.p1.y;
        double x2 = line1.p2.x;
        double y2 = line1.p2.y;
        double x3 = line2.p1.x;
        double y3 = line2.p1.y;
        double x4 = line2.p2.x;
        double y4 = line2.p2.y;
        
        double denom = ( (y4 - y3) * (x2 - x1) ) - ( (x4 - x3) * (y2 - y1) );
        
        // Lines are parallel.
        
        if (denom == 0.0) { 
            point = null;
            return point;
        }
        
        double ua = ( (x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3) ) / denom;
        double ub = ( (x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3) ) / denom;
        
        
        if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
            point = new Point();
            point.x = ( x1 + ua * (x2 - x1) );
            point.y = ( y1 + ua * (y2 - y1) );
            return point;
        }
        
        point = null;
        return point;
    }
}