package TrianglePackage;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        boolean succeed = false;
        Scanner in = new Scanner(System.in);
        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle();
        while (!succeed) {          //Will be looping untill user enters right sides
            System.out.println("Enter 3 doubles to assign to the first triangle sides:");
            double side1, side2, side3;
            System.out.print("side1: ");
            side1 = in.nextDouble();
            System.out.print("side2: ");
            side2 = in.nextDouble();

            System.out.print("side3: ");
            side3 = in.nextDouble();
            try {
                triangle1 = new Triangle(side1, side2, side3);
                succeed = true;
            } catch (Exception ex) {
            }
        }
        succeed = false;
        while (!succeed) {          //Will be looping untill user enters right sides
            System.out.println("Enter 3 doubles to assign to the first triangle sides:");
            double side1, side2, side3;
            System.out.print("side1: ");
            side1 = in.nextDouble();
            System.out.print("side2: ");
            side2 = in.nextDouble();
            System.out.print("side3: ");
            side3 = in.nextDouble();
            try {
                triangle2 = new Triangle(side1, side2, side3);
                succeed = true;
            } catch (Exception ex) {
            }
        }
        System.out.println("First triangle area is " + triangle1.area());
        System.out.println();
        System.out.println("Second triangle area is " + triangle2.area());
    }
}
