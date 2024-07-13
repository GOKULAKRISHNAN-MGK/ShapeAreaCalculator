package com.example.shapes.factory;

import com.example.shapes.model.Circle;
import com.example.shapes.model.Rectangle;
import com.example.shapes.model.Shape;
import com.example.shapes.model.Square;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShapeFactory {

    @Autowired
    private Map<String, Shape> shapeBeans;

    public Shape getShape(String shapeType, double... dimensions) {
        Shape shape = shapeBeans.get(shapeType.toLowerCase());
        if (shape == null) {
            throw new IllegalArgumentException("Invalid shape type");
        }

        if (shape instanceof Circle) {
            return Circle.builder().radius(dimensions[0]).build();
        } else if (shape instanceof Rectangle) {
            return Rectangle.builder().length(dimensions[0]).width(dimensions[1]).build();
        } else if (shape instanceof Square) {
            return Square.builder().side(dimensions[0]).build();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }
}
