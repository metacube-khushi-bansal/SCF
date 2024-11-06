package Main.java;

public class Square implements Shape {

    private Point origin;
    private double side;

    public Square(Point origin, double side) {
        this.origin = origin;
        this.side = side;
    }
    @Override
    public double getArea() {
       return side * side;    
    }

    @Override
    public double getPerimeter() {
       return side * 4;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
       return point.getXCoordinate() >= origin.getXCoordinate() && point.getXCoordinate() <= origin.getXCoordinate() + side
       && point.getYCoordinate() >= origin.getYCoordinate() && point.getYCoordinate() <= origin.getYCoordinate() + side;
        
    }

}
