
/**
 * 
 *  Plots results
 *   
 */

import java.util.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Plot extends JFrame {
    Circle circle;
    Scatter scatter;
    int w, h;
    Transformation transform;
    double scale;

    public Plot(int w, int h, double scale, Circle circle, Scatter scatter) {
        this.w = w;
        this.h = h;
        this.scale = scale;
        this.circle = circle;
        this.scatter = scatter;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setVisible(true);        
    }
    
    public void paint(Graphics g) {
        transform = new Transformation();
        transform.identity();
        transform.translate(-circle.center.x, -circle.center.y);
        transform.scale(scale, scale);
        transform.translate((double) w / 2.0, (double) h / 2.0);
        plotSpokes(g);
        plotScatter(g);
    }
    
    void plotSpokes(Graphics g) {
        Point point;
        int x1, y1, x2, y2;
        
        point = circle.center;
        point = transform.doTransformation(point);
        
        x1 = (int) point.x;
        y1 = (int) point.y;
        
        
        for (int i = 0; i < circle.spokePoints.size(); i++) {
            point = circle.spokePoints.get(i);
            point = transform.doTransformation(point);
            x2 = (int) point.x;
            y2 = (int) point.y;
            g.drawLine(x1, y1, x2, y2);
        }              
    }
    
    void plotScatter(Graphics g) {
        Point point;
        int x1, y1, x2, y2;
        int endIndex;
        
        
        endIndex = scatter.scatterPoints.size() - 1;
        
        for (int i = 0; i < endIndex; i++) {
             point = scatter.scatterPoints.get(i);
             point = transform.doTransformation(point);
             x1 = (int) point.x;
             y1 = (int) point.y;
             
             point = scatter.scatterPoints.get(i+1);
             point = transform.doTransformation(point);
             x2 = (int) point.x;
             y2 = (int) point.y;
             g.drawLine(x1, y1, x2, y2);
        }
    }
    
    void promptEnterKey() {
    
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
