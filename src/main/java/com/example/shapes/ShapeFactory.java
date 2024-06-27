package com.example.shapes;

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
            return new Circle(dimensions[0]);
        } else if (shape instanceof Rectangle) {
            return new Rectangle(dimensions[0], dimensions[1]);
        } else if (shape instanceof Square) {
            return new Square(dimensions[0]);
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }
}
