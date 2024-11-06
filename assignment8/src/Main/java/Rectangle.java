package Main.java;

public class Rectangle implements Shape {

    private Point origin;
    private double length;
    private double breadth;

    public Rectangle(Point origin, double length, double breadth) {
        this.origin = origin;
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + breadth);
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        return point.getXCoordinate() >= origin.getXCoordinate()
                && point.getXCoordinate() <= origin.getXCoordinate() + length
                && point.getYCoordinate() >= origin.getYCoordinate()
                && point.getYCoordinate() <= origin.getYCoordinate() + breadth;

    }

}
