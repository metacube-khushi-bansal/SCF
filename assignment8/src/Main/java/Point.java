package Main.java;

public class Point {
   private double xCoordinate;
   private double yCoordinate;


   public Point(double x, double y) {
     this.xCoordinate = x;
     this.yCoordinate = y;
   }

   public double getXCoordinate(){
    return xCoordinate;
   }

   public double getYCoordinate(){
    return yCoordinate;
   }

   public double distanceOfPoints(Point point1, Point point2){
    double distance =  Math.sqrt((Math.pow(point1.getXCoordinate() - point2.getXCoordinate(), 2)
    + Math.pow(point1.getYCoordinate() - point2.getYCoordinate(), 2)));
    return distance;
   }
}
