package com.example.shapes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shape")
public class ShapeController {

    @Autowired
    private ShapeFactory shapeFactory;

    @GetMapping("/area")
    public double getShapeArea(@RequestParam String type, @RequestParam double[] dimensions) {
        Shape shape = shapeFactory.getShape(type, dimensions);
        return shape.calculateArea();
    }
}
