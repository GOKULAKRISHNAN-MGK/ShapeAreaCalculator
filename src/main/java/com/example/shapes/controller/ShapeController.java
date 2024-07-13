package com.example.shapes.controller;

import com.example.shapes.factory.ShapeFactory;
import com.example.shapes.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

    @Autowired
    private ShapeFactory shapeFactory;

    @GetMapping("/area")
    public double getShapeArea(@RequestParam String type, @RequestParam double[] dimensions) {
        Shape shape = shapeFactory.getShape(type, dimensions);
        return shape.calculateArea();
    }
}
