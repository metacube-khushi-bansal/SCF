package Main.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {
    private double XMAX = 1000.0;
    private double YMAX = 1000.0;
    private List<Shape> shapes = new ArrayList<>();
    private Map<Shape, LocalDateTime> timeStamps = new HashMap<>();

    public void addShape(Shape shape) {

        shapes.add(shape);
        timeStamps.put(shape, LocalDateTime.now());
    }

    public List<Shape> getShapes(){
        return shapes;
    }

    public Map<Shape,LocalDateTime>getTimeStamps(){
        return timeStamps;
    }

    public void deleteShape(Shape shape) {
        shapes.remove(shape);
        timeStamps.remove(shape);
    }

    public void deleteAllShapesByType(Shape.ShapeType type) {

        List<Shape> shapesToRemove = new ArrayList<>();

        for(Shape shape: shapes){
            if(shape.getClass().getSimpleName().equalsIgnoreCase(type.name())){
                shapesToRemove.add(shape);
                timeStamps.remove(shape);
            }
        }
        shapes.removeAll(shapesToRemove);
    }

    public List<Shape> getShapesSortedBy(Comparator<Shape> comparator) {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(comparator);
        return sortedShapes;
    }

    public List<Shape> getShapesEnclosingPoint(Point point) {
        List<Shape> enclosingShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.isPointEnclosed(point))
                enclosingShapes.add(shape);
        }
        return enclosingShapes;
    }
}

