package com.example.shapes.model;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component("square")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Square implements Shape {
    private double side;

    @Override
    public double calculateArea() {
        return side * side;
    }

    @PostConstruct
    public void init() {}
}
