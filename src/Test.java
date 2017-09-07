import java.util.*;

public class Test {

    void printPoints(ArrayList<Point> list) {
        Point point;
        
        for (int i = 0; i < list.size(); i++) {
            point = list.get(i);
            System.out.println(point.x + "," + point.y);
        }
    }
    
    void printPoint(Point point) {
        System.out.println(point.x + "," + point.y);
    } 
    
    void printLine(Line line) {
        System.out.println(line.p1.x + "," + line.p1.y + "," + line.p2.x + "," + line.p2.y);
    }
     
    void printMatrix(Transformation transform) {
        for (int i = 0; i < 3; i++) {
            System.out.println(transform.matrix[i][0] + "    " + transform.matrix[i][1] + "    " + transform.matrix[i][2]);
        }
    } 
    
    void printCircle(Circle circle) {
        System.out.println("center = " + circle.center.x + "," + circle.center.y + "    radius = " + circle.radius);

    }
    
    void printDeviations(Scatter scatter) {
        Deviation deviation;
        
        for (int i = 0; i < scatter.deviations.size(); i++) {
            deviation = scatter.deviations.get(i);
            System.out.println((int) deviation.degree + "    " + deviation.ratio);
        }
    }
        
        
}
