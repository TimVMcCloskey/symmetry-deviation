import java.util.*;

//*****************************************************************************
//
//  Scatter
//
//  Scatter class holding digitized fragments coordinates,
//  intersections of 2 fragment end points with each spoke,
//  and deviations from circle [1.0 - (ratio of intersection / spoke length)]
//
//******************************************************************************

public class Scatter {  
    public ArrayList<Point> scatterPoints;
    public ArrayList<Deviation> deviations;
     
    public Scatter() {
        this.scatterPoints = new ArrayList<Point>();
    }
    
    void getRatios(Circle spokes) {
        CalcLines calc = new CalcLines();
        
        // current intersection
        Point intersection;
        Point p1, p2;
        
        // current spoke line
        Line spokeLine = new Line();
        
        // current scatter line
        Line scatterLine = new Line();
        
        // current spoke intersection with current scatter line
        Line clipLine = new Line();
        
        double degree;
        double spokeLength;
        int endIndex;
        Deviation currentDeviation;
        
        spokeLength = spokes.radius;
        deviations = new ArrayList<Deviation>();
        endIndex = scatterPoints.size() - 1;
        degree = 0.0;
        
        // iterate through spokes storing current spoke degree,
        // current spoke endpoint, and spoke length as inital deviation
        for (int i = 0; i < spokes.spokePoints.size(); i++) {
            currentDeviation = new Deviation();
            currentDeviation.degree = degree;
            spokeLine.p1 = spokes.center;
            spokeLine.p2 = spokes.spokePoints.get(i);
            currentDeviation.spokeLength = spokeLength;           
            
            // iterate through scatter points
            for (int j = 0; j < endIndex; j++) {
                scatterLine.p1 = scatterPoints.get(j);
                scatterLine.p2 = scatterPoints.get(j+1);
                intersection = calc.intersection(spokeLine, scatterLine);                
                
                // no intersection
                if (intersection == null) {
                    continue;
                }
                
                // there is an intersection
                currentDeviation.intersection = intersection;
                clipLine.p1 = spokes.center;
                clipLine.p2 = intersection;
                
                // get length of clipped spoke
                currentDeviation.scatterLength = calc.length(clipLine);
                
                // get deviation of this clipped line from outer circle
                currentDeviation.ratio = 1.0 - (currentDeviation.scatterLength / currentDeviation.spokeLength);
                deviations.add(currentDeviation);
                break;
            }
            
            degree += spokes.degree;
        }
    }
}

