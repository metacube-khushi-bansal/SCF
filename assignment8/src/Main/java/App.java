package Main.java;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        Screen screen = new Screen();
        // Creating and adding shapes to the screen
        Shape circle = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(100, 100), List.of(50));
        Shape square1 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(150, 150), List.of(40));
        Shape square2 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(170, 160), List.of(20));
        Shape rectangle1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(200, 200), List.of(60, 30));
        Shape rectangle2 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(120, 100), List.of(20, 38));
        Shape triangle = ShapeFactory.createShape(Shape.ShapeType.TRIANGLE, new Point(250, 250), List.of(50, 30));
        screen.addShape(circle);
        screen.addShape(square1);
        screen.addShape(square2);
        screen.addShape(rectangle1);
        screen.addShape(rectangle2);
        screen.addShape(triangle);


       Map<Shape, LocalDateTime> timeStamps = screen.getTimeStamps();
       for(Shape shape: timeStamps.keySet()){
        System.out.println("Shape:" + shape.getClass().getSimpleName() + " Time created: " + timeStamps.get(shape));
       }


        // Displaying shapes sorted by area
        List<Shape> sortedByArea = screen.getShapesSortedBy(Comparator.comparingDouble(Shape::getArea));
        System.out.println("Shapes sorted by area:");
        for (Shape shape : sortedByArea) {
            System.out.println(shape.getClass().getSimpleName() + " - Area: " + shape.getArea());
        }

        // Finding shapes enclosing a point
        Point testPoint = new Point(105, 105);
        List<Shape> shapesEnclosingPoint = screen.getShapesEnclosingPoint(testPoint);
        System.out.println("\nShapes enclosing point (105, 105):");
        for (Shape shape : shapesEnclosingPoint) {
            System.out.println(shape.getClass().getSimpleName());
        }

        screen.deleteShape(square1);
        List<Shape> sortedByPerimeter = screen.getShapesSortedBy(Comparator.comparingDouble(Shape::getPerimeter));
        System.out.println("Shapes sorted by Perimeter:");
        for (Shape shape : sortedByPerimeter) {
            System.out.println(shape.getClass().getSimpleName() + " - Perimeter: " + shape.getPerimeter());
        }
        System.out.println();
        System.out.println();

        screen.deleteAllShapesByType(Shape.ShapeType.RECTANGLE);
        List<Shape> sortedByPerimeter1 = screen.getShapesSortedBy(Comparator.comparingDouble(Shape::getPerimeter));
        System.out.println("Shapes sorted by Perimeter:");
        for (Shape shape : sortedByPerimeter1) {
            System.out.println(shape.getClass().getSimpleName() + " - Perimeter: " + shape.getPerimeter());

        }
        
    }
}