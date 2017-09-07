import java.util.*;


public class Scatter {  
    public ArrayList<Point> scatterPoints;
    public ArrayList<Deviation> deviations;
     
    public Scatter() {
        this.scatterPoints = new ArrayList<Point>();
    }
    
    void getRatios(Circle spokes) {
        CalcLines calc = new CalcLines();
        Point intersection;
        Point p1, p2;
        Line spokeLine = new Line();
        Line scatterLine = new Line();
        Line clipLine = new Line();
        double degree;
        double spokeLength;
        int endIndex;
        Deviation currentDeviation;
        
        spokeLength = spokes.radius;
        deviations = new ArrayList<Deviation>();
        endIndex = scatterPoints.size() - 1;
        degree = 0.0;
        
        for (int i = 0; i < spokes.spokePoints.size(); i++) {
            currentDeviation = new Deviation();
            currentDeviation.degree = degree;
            spokeLine.p1 = spokes.center;
            spokeLine.p2 = spokes.spokePoints.get(i);
            currentDeviation.spokeLength = spokeLength;           
            
            for (int j = 0; j < endIndex; j++) {
                scatterLine.p1 = scatterPoints.get(j);
                scatterLine.p2 = scatterPoints.get(j+1);
                intersection = calc.intersection(spokeLine, scatterLine);                
                
                if (intersection == null) {
                    continue;
                }
                
                currentDeviation.intersection = intersection;
                clipLine.p1 = spokes.center;
                clipLine.p2 = intersection;
                currentDeviation.scatterLength = calc.length(clipLine);
            
                currentDeviation.ratio = 1.0 - (currentDeviation.scatterLength / currentDeviation.spokeLength);
                deviations.add(currentDeviation);
                break;
            }
            
            degree += spokes.degree;
        }
    }
}

