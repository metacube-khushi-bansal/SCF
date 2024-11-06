package Main.java;

public interface Shape {
    enum ShapeType{
        CIRCLE,
        TRIANGLE,
        SQUARE,
        RECTANGLE,
        POLYGON
    }
    double getArea();

    double getPerimeter();

    Point getOrigin();

    boolean isPointEnclosed(Point point);

}
