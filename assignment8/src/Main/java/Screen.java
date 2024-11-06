package Main.java;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Main.java.Shape.ShapeType;

public class Screen {
    private double xMax;
    private double yMax;
    private List<Shape> shapes = new ArrayList<>();
    private Map<Shape, LocalDateTime> timeStamps = new HashMap<>();
    public Screen(double xMax, double yMax) {

         this.xMax = xMax;
         this.yMax = yMax;
    }

    public void addShape(Shape shape) {
        
        shapes.add(shape);
        timeStamps.put(shape, LocalDateTime.now());
    }

    public void deleteShape(Shape shape) {
        shapes.remove(shape);
        timeStamps.remove(shape);
    }

    public void deleteAllShapesByType(Shape.ShapeType type) {

        for(Shape shape : shapes){
            if(shape.getClass().getSimpleName().equalsIgnoreCase(type.name()))
            shapes.remove(shape);
        }
        
    }


    public List<Shape> getShapesSortedBy(Comparator <Shape> Comparator){
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(Comparator);
        return sortedShapes;
    }


    public List<Shape> getShapesEnclosingPoint(Point point){
        List<Shape> enclosingShapes = new ArrayList<>();
        for(Shape shape: shapes){
            if(shape.isPointEnclosed(point) )
            enclosingShapes.add(shape);
        }
        return enclosingShapes;
    }
}

class AreaComparator implements Comparator <Shape>{

    @Override
    public int compare(Shape s1,Shape s2){
        return Double.compare(s1.getArea(), s2.getArea());
    }
}

class PerimeterComparator implements Comparator <Shape>{

    @Override
    public int compare(Shape s1,Shape s2){
        return Double.compare(s1.getPerimeter(), s2.getPerimeter());
    }
}

