
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
        
        // Get fragment outline from svg file
        scatter = geoIo.getScatterPath(args[0]);
        
        // Get circle from svg file
        circle = geoIo.getCircle(args[0]);
        
        // Get spokes at 10 degree intervals
        circle.getSpokes(10);
        
        // Get the deviations of each spoke clipped with fragments
        scatter.getRatios(circle);
            
        // Plot it
        Plot plot = new Plot(800, 600, 7.5, circle, scatter);
        
        // And write out each angle with deviation
        geoIo.writeDeviations(args[1], scatter);
    }   
}

