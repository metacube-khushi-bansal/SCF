package Main.java;

import java.util.List;


public class ShapeFactory {
    public static Shape createShape(Shape.ShapeType type, Point origin, List<Integer> parameters) {
        switch (type) {
            case SQUARE:
                return new Square(origin, parameters.get(0));
            case CIRCLE:
                return new Circle(origin, parameters.get(0));
            case RECTANGLE:
                return new Rectangle(origin, parameters.get(0), parameters.get(1));
            case TRIANGLE:
                return new Triangle(origin, parameters.get(0), parameters.get(1));
            case POLYGON:
                return new  Polygon(origin, parameters.get(0), parameters.get(1), parameters.get(2));   

            default:
                throw new IllegalArgumentException("Unknown shape type!");
        }
    }
}
