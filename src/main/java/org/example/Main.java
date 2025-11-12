package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter coordinates: ");
        double[] x = new double[3];
        double[] y = new double[3];

        for (int i = 0; i < 3; i++) {
            x[i] = readDouble(userInput);
            y[i] = readDouble(userInput);
        }
        double a = calculate_distance(x[0], y[0], x[1], y[1]);
        double b = calculate_distance(x[1], y[1], x[2], y[2]);
        double c = calculate_distance(x[2], y[2], x[0], y[0]);

        if (isTriangle(a, b, c)) {
            double perimetr = a + b + c;
            System.out.printf("Perimetr: %.3f%n", perimetr);
        } else {
            System.out.println("It's not a triangle");
        }
    }

    private static double readDouble(Scanner userInput) {
        while (true) {
            try {
                return Double.parseDouble(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    private static double calculate_distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}