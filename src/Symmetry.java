
/**
 * Calculate percentage of glass fragments deviation from a symmetrical circle.
 * 
 * @author (Tim McCloskey) 
 * @version (1.0)
 */

import java.io.*;
import java.util.*;

public class Symmetry {
         
    public static void main( String args[] ) {
        Scatter scatter;
        Circle circle;

        GeoIo geoIo = new GeoIo();
        scatter = geoIo.getScatterPath(args[0]);
        
        circle = geoIo.getCircle(args[0]);
        circle.getSpokes(10);
        
        scatter.getRatios(circle);
        Plot plot = new Plot(800, 600, 7.5, circle, scatter);
        
        geoIo.writeDeviations(args[1], scatter);
    }   
}

