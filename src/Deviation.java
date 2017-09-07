
/**
 * 
 *  Deviation records
 *   
 */

public class Deviation {
    public double degree;  
    public Point intersection;
    public double spokeLength;
    public double scatterLength;
    public double ratio;

    public Deviation() {
        this.degree = 0.0;
        this.intersection = new Point();
        this.spokeLength = 0.0;
        this.scatterLength = 0.0;
        this.ratio = 0.0;
    }
}
