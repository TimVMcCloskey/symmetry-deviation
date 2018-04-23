
//*********************
//
//  Represents an line
//
//*********************

public class Line {
    public Point p1, p2;

    public Line() {
        this.p1 = new Point();
        this.p2 = new Point();
    }
    
    public Line(Point b, Point e) {
        this.p1 = b;
        this.p2 = e;
    }
    
    public Line(double x1, double y1, double x2, double y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }
}
