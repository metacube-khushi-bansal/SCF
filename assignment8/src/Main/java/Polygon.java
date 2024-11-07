package Main.java;


public class Polygon implements Shape {

    private Point origin;
    private double side;
    private int noOfSides;
    private double angle;

    public Polygon(Point origin, double side, int noOfSides, double angle) {
        this.origin = origin;
        this.side = side;
        this.noOfSides = noOfSides;
        this.angle = angle;

    }

    @Override
    public double getArea() {
       
        double apothem = (side / 2) * (Math.tan(180 / noOfSides));
        double area = (noOfSides * side * apothem) / 2;
        return area;
    }

    @Override
    public double getPerimeter() {
       
        return noOfSides * side;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        // Calculate the angle between the origin and the given point
        double centerAngle = angleBetweenPoints(this.origin, point);
    
        // Calculate the angle section based on the polygon's internal angle
        double sectionAngle = (angle - Math.floor(centerAngle / angle) * angle);
    
        // Calculate the distance from the origin to the point
        double distanceToPoint = origin.distanceOfPoints(origin, point);
    
        // Calculate the radius using the polygon's side length
        double radius = (side / (2 * Math.sin(Math.PI / noOfSides)));
    
        // Check if the point lies within the radius for this angle section
        return distanceToPoint <= radius * Math.cos(sectionAngle / 2);
    }
    
    public double angleBetweenPoints(Point rightPoint, Point leftPoint) {

        double rightToLeft = rightPoint.distanceOfPoints(leftPoint, rightPoint);
        double thisToRight = rightPoint.distanceOfPoints(rightPoint, origin);
        double thisToLeft = leftPoint.distanceOfPoints(leftPoint, origin);
        return Math.cos((thisToLeft * thisToLeft + thisToRight * thisToRight - rightToLeft * rightToLeft)
                / (2 * thisToLeft * thisToRight));

    }

}
