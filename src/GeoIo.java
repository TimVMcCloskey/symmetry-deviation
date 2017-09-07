import java.io.*;
import java.util.*;


public class GeoIo {
    
    
    //************************************************************
    //
    //  getTracePath
    //
    //************************************************************
    
    Scatter getScatterPath(String svgFile) {
        Scatter scatter = new Scatter();
        String line;
        int position;
        double x= 0;
        double y = 0;
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(svgFile));
                   
            while( (line = in.readLine()) != null ) {
                String path = new String("<path");
                position = line.indexOf(path);
                
                if( position == 0) {
                    Scanner input = new Scanner(line);
                    input.useDelimiter(" ");
                    
                    boolean newPoint = true;
                    
                    while (input.hasNext()) { 
                        String next = input.next();
                        String num = next.replaceAll("[^0-9-.]","");
                            
                        if(isDouble(num)) { 
                            
                            if(newPoint) {
                                x = Double.valueOf(num);                                
                                newPoint = false;
                            } else {  
                                y = Double.valueOf(num);
                                scatter.scatterPoints.add(new Point(x,y));
                                newPoint = true;
                            }
                        }
                    }
                }
            }
            
            in.close();
            
        } catch (IOException e) {
            System.out.println("File I/O error!"); 
        }
        return scatter;
    }
    
    
    
    
    //************************************************************
    //
    //  getCircle
    //
    //************************************************************
    
    Circle getCircle(String svgFile) {
        
        String line;
        int position;
        Point point = new Point(0.0,0.0);
        Circle circle = new Circle();
              
        try {
            BufferedReader in = new BufferedReader(new FileReader(svgFile));
                   
            while( (line = in.readLine()) != null ) {
                String path = new String("<circle");
                position = line.indexOf(path);
                
                if( position == 0) {   
                    
                    Scanner input = new Scanner(line);
                    input.useDelimiter(" ");
                    int numValues = 0;
                    
                    while (input.hasNext()) { 
                        String next = input.next();
                        String num = next.replaceAll("[^0-9-.]","");
                            
                        if(isDouble(num)) { 
                            
                            if(numValues == 0) {
                                point.x = Double.valueOf(num);                                
                                numValues++;
                                continue;
                            }  
                        
                            if(numValues == 1) {
                                point.y = Double.valueOf(num);
                                circle.center = point;
                                numValues++;
                                continue;
                            } 
                        
                            if(numValues == 2) {
                                circle.radius = Double.valueOf(num);   
                                break;
                            }
                        }
                    }
                }
            }
            
            in.close();
            
        } catch (IOException e) {
            System.out.println("File I/O error!"); 
        }
        
        return circle;
    }
    
    
    
    void writeDeviations(String deviationFile, Scatter scatter) {
        Deviation deviation;
        
        try {
            PrintStream file = new PrintStream(new File(deviationFile));
            file.println("Angle         Deviation");
            
            for (int i = 0; i < scatter.deviations.size(); i++) {
                deviation = scatter.deviations.get(i);
                file.println((int) deviation.degree + "       " + deviation.ratio );
            }
            
            file.close();
            
        } catch(IOException e) {
            System.out.println("File I/O error!"); 
        }
    }
    
    


    //************************************************************
    //
    //  isDouble
    //
    //************************************************************
        
    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}



