package com.example.shapes.aspect;

import com.example.shapes.exception.RestrictedShapeException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.example.shapes.factory.ShapeFactory.getShape(..)) && args(shapeType, ..)")
    public void checkRestrictedShapes(String shapeType) {
        if("trapezoid".equalsIgnoreCase(shapeType)) {
            throw new RestrictedShapeException("Access Denied for the Shape: "+shapeType);
        }
    }
}
