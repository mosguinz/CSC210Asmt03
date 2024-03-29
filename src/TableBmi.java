/*
 * Assignment 03
 * Description: [Part 1 of 3] BMI History Pro
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

import java.util.Scanner;

public class TableBmi {

    /* 63-column wide separator in compliance with (3)(a). */
    private static final String LINE_SEP = "^".repeat(63);

    public static void main(String[] args) {
        loop();
    }

    /**
     * Display the BMI table from the given parameters.
     *
     * @param height The height in inches.
     * @param weightMax The maximum weight in pounds.
     * @param weightMin THe minimum weight in pounds.
     */
    private static void displayTable(double height, double weightMax, double weightMin) {
        /* Print table header. */
        System.out.println("\nWEIGHT\t BMI\t\t CONDITION");

        /* Generate and print BMI table in increments of 5 lbs.*/
        double bmi;
        String cond;
        for (; weightMin <= weightMax; weightMin += 5) {
            /* Calculate the BMI. */
            bmi = calculateBMI(weightMin, height);
            /* Determine if the BMI is considered "overweight". */
            cond = bmi > 25 ? "overweight" : "not overweight";
            /* Print the table row. */
            System.out.printf("%.0f\t\t %3.4f\t %s%n", weightMin, bmi, cond);
        }
    }

    /**
     * Calculate the BMI from the given weight and height.
     *
     * @param weight Weight in pounds.
     * @param height Height in inches.
     * @return The BMI value (lbs/in^2).
     */
    private static double calculateBMI(double weight, double height) {
        return 703 * weight / (height * height);
    }

    /**
     * Print the program header.
     * Made to be identical to the example, as required by part (1)(5).
     */
    private static void printHeader() {
        System.out.println(LINE_SEP);
        System.out.println("^ Welcome to:");
        System.out.println("^    BODY MASS INDEX (BMI) Computation PRO");
        System.out.println("^               by Mos");
        System.out.println("^");
        System.out.println(LINE_SEP);
    }

    /**
     * Run the program loop.
     */
    public static void loop() {
        printHeader();

        /* Create a Scanner object. */
        Scanner scan = new Scanner(System.in);

        /* Input prompts for height (in feet and inches, split on first whitespace) */
        System.out.print("Enter height in feet and inches: ");
        int height = scan.nextInt() * 12 + scan.nextInt();

        /* Input prompts for min and max weights. */
        System.out.print("Enter the low weight in pounds: ");
        double weightMin = scan.nextDouble();
        System.out.print("Enter the high weight in pounds: ");
        double weightMax = scan.nextDouble();

        /* Display the table and print termination message. */
        displayTable(height, weightMax, weightMin);
        System.out.println('\n' + LINE_SEP);
        System.out.println("^    Thank you for using my program.");
        System.out.println(LINE_SEP);
    }
}
