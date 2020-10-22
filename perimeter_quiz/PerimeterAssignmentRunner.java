import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int NumPoints = 0;
        for (Point P : s.getPoints()){
            NumPoints += 1;
        }
        return NumPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longer = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(longer < currDist){
                longer = currDist;
            }
            prevPt = currPt;
           
        }
        return longer;
    }
    
    public double getLargestX(Shape s) {
       double larger = 0.0;

        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            if(larger < currX){
                larger = currX;
            }          
        }
        return larger;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPer = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPer){
                largestPer = getPerimeter(s);
            }
        }
        return largestPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestPer = 0.0;
        DirectoryResource dir = new DirectoryResource();
        for (File f : dir.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPer){
                largestPer = getPerimeter(s);
                temp = f;
            }
        }        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int NumPoints = getNumPoints(s);
        double avgLen = getAverageLength(s);
        double longer = getLargestSide(s);
        double larger = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + NumPoints);
        System.out.println("average length = " + avgLen);
        System.out.println("largest side = " + longer);
        System.out.println("largest x = " + larger);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPer = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPer);
        //System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
