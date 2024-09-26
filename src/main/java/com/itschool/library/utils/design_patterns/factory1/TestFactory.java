package com.itschool.library.utils.design_patterns.factory1;

public class TestFactory {

    public static void main(String[] args) {
        ShapeFactory shapefactory = new ShapeFactory();

        Shape circle = shapefactory.createShape("circle");
        circle.draw();

        Shape triangle = shapefactory.createShape("triangle");
        triangle.draw();
    }
}