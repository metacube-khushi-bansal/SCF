package Main.java;

public class Circle implements Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Point getOrigin() {
        // yet to  be computed
        return center;
    }

    @Override
    public boolean isPointEnclosed(Point point) {
        double distanceOfPointFromCenter = point.distanceOfPoints(point, center);
        if (distanceOfPointFromCenter < radius)
            return true;
        else
            return false;
    }

}
