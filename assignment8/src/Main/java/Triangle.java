package Main.java;

public class Triangle implements Shape {
    private Point origin;
    private double base;
    private double height;

    public Triangle(Point origin, double base, double height) {
        this.origin = origin;
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = (base * height) / 2;
        return area;
    }

    @Override
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        if (point.getXCoordinate() >= origin.getXCoordinate()
                || point.getXCoordinate() <= origin.getXCoordinate() + base ||
                point.getYCoordinate() >= origin.getYCoordinate()
                || point.getYCoordinate() <= origin.getYCoordinate() + height)
            return false;

         double hypotenuseY = -(height/base)  * (point.getXCoordinate() - origin.getXCoordinate() + (origin.getYCoordinate() - height));
         return point.getYCoordinate() <= hypotenuseY;   
    }

}
