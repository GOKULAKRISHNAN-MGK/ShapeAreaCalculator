package com.example.shapes.model;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component("rectangle")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rectangle implements Shape {
    private double length;
    private double width;

    @Override
    public double calculateArea() {
        return length * width;
    }

    @PostConstruct
    public void init() {}
}
