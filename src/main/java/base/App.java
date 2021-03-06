package base;

/*

 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Sahar Sheikholeslami

 */

/*
Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs
and then use that result to make a determination.

Create a program that prompts for your weight, gender,
total alcohol consumed (in ounces), and the amount of time since your last drink.
Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Your BAC is 0.08
It is not legal for you to drive.
Constraint
Prevent the user from entering non-numeric values.
Challenges
1- Handle metric units.
2- Look up the legal BAC limit by state and prompt for the state. Display a message that
states whether or not it’s legal to drive based on the computed BAC.
3- Develop this as a mobile application that makes it easy to record each drink,
updating the BAC each time a drink is entered.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final double MALE_R = 0.73;
        final double FEMALE_R = 0.66;
        final double LEGAL_LIMIT = 0.08;

        Scanner input = new Scanner(System.in);
        //boolean stringChecker=true;

        System.out.print("Enter total alcohol consumed in (oz): ");
        String check = input.nextLine();

        while (!isNum(check)) {
            System.out.print("enter a valid numerical value: ");
            check = input.nextLine();
        }

        int consumedAlcohol = Integer.parseInt(check);

        System.out.print("Enter your body weight in pounds (lbs): ");
        check = input.nextLine();

        while (!isNum(check)) {
            System.out.print("enter a valid numerical value: ");
            check = input.nextLine();
        }

        int bodyWeight = Integer.parseInt(check);

        System.out.print("Enter number of hours since the last drink: ");
        check = input.nextLine();

        while (!isNum(check)) {
            System.out.print("enter a valid numerical value: ");
            check = input.nextLine();
        }

        int numHours = Integer.parseInt(check);


        System.out.print("Enter your gender (M or F): ");
        check = input.nextLine();


        double ratio= check.toUpperCase().equals("M") ? MALE_R : FEMALE_R;


        double BAC = ( ((consumedAlcohol * 5.14) / (bodyWeight*ratio))- (0.015*numHours));
        BAC = (double) Math. round(BAC * 100) / 100;

        System.out.println("Your BAC is "+ BAC);

        System.out.println( (BAC>=LEGAL_LIMIT) ? "It is not legal for you to drive." : "You can drive!");




    }


    public static boolean isNum(String numTest) {
        if (numTest == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(numTest);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

