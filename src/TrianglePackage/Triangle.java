package TrianglePackage;

import java.util.Objects;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {

    }

    public Triangle(double side1, double side2, double side3) {
        if ((side1 + side2) < side3 ||
                (side1 + side3) < side2 ||
                (side2 + side3) < side1)
            throw new IllegalArgumentException("Triangle cannot be formed of these three sides");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }// Geron's Formula for the triangle area (p is a halfperimeter)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side1, side1) == 0 &&
                Double.compare(triangle.side2, side2) == 0 &&
                Double.compare(triangle.side3, side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side1, side2, side3);
    }

}
