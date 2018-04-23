
//*****************************
//
//  Transformation
//
//  2d matrix transformations
//
//*****************************

public class Transformation {

    public double[][] matrix;
       
    public Transformation() {
        matrix = new double[3][3];
        identity();
    }
        
    void identity() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {  
                if(i==j) {
                    matrix[i][j] = 1.0;
                } else {
                    matrix[i][j] = 0.0;
                }
            }
        }
    }    
    
    void scale(double sx, double sy) {
        
        for (int i = 0; i < 3; i++) {
            matrix[i][0] = matrix[i][0] * sx;
            matrix[i][1] = matrix[i][1] * sy;
        }
    }
            
    void translate(double tx, double ty) {
        matrix[2][0] += tx;
        matrix[2][1] += ty;
    }
    
    void rotate(double angle) {
        double radians;
        double c, s;
        double temp;
        
        radians = Math.toRadians(angle);
        s = Math.sin(radians);
        c = Math.cos(radians);
        
        if(angle == 90) {
            s = 1.0;
            c = 0.0;           
        }
        
        if(angle == 180) {
            s = 0.0;   
            c = -1.0;
        }
        
        if (angle == 270) {
            s = -1.0;
            c = 0.0;
        }
        
        
   
        for (int i = 0; i < 3; i++) {
            temp = matrix[i][0] * c - matrix[i][1] * s;
            matrix[i][1] = matrix[i][0] * s + matrix[ i][1] * c;
            matrix[i][0] = temp;
        }
    }
    
    Point doTransformation(Point point) {
        double x, y; 
        
        x = point.x * matrix[0][0] + point.y * matrix[1][0] + matrix[2][0];
        y = point.x * matrix[0][1] + point.y * matrix[1][1] + matrix[2][1];
        return (new Point(x,y));
    }     
}

        
                
                
                
        
    
    
   
