package Java;
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point p : s.getPoints()){
            count += 1;
        }
        return count;
    }

    public double getAverageLength(Shape s){
        int count=0;
        double totalLength = 0.0;
        double average=0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currLength = prevPt.distance(currPt);
            totalLength = totalLength + currLength;
            prevPt = currPt;
            count=+1;
            average=totalLength/count;
        }

        return average;

    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        double sideLength = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            sideLength = prevPt.distance(currPt);
            if(sideLength>largestSide)
                largestSide=sideLength;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestPoint = 0.0;
        double currentPoint = 0.0;
        for (Point currPt : s.getPoints()) {
            currentPoint = currPt.getX();
            if (currentPoint > largestPoint) {
                largestPoint = currentPoint;
            }
        }
        return largestPoint;
    }

    public double getLargestPerimeterMultipleFiles() {
        double currPerimeter=0.0;
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape shape = new Shape(fr);
            currPerimeter=getPerimeter(shape);
            if (currPerimeter>maxPerimeter)
                maxPerimeter=currPerimeter;
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        File currFile = null;
        double currPerimeter=0.0;
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPerimeter=getPerimeter(s);
            if (currPerimeter>maxPerimeter){
                maxPerimeter=currPerimeter;
                currFile=f;
            }
        }
        return currFile.getName();
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int count = getNumPoints(s);
        System.out.println("Count = "+ count);
        double averageLength=getAverageLength(s);
        System.out.println("Average Length is = "+averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side = " +largestSide);
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    public void testPerimeterMultipleFiles() {
        double Perimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter across multiple files is: "+Perimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("File name with largest perimeter is: "+fileName);

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
        pr.testPerimeter();
    }
}
