package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 17 Solution
 *  Copyright 2021 Daniel Ragusa
 */

import java.util.Scanner;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class App
{
    public static void main(String[] args)
    {
        int gender;
        double weight;
        double consumed_alc;
        double time_since_drink;
        double BAC;
        double conversion_rate;
        String answer;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
        gender = input.nextInt();

        System.out.print("How many ounces of alcohol did you have? ");
        consumed_alc = input.nextDouble();

        System.out.print("What is your weight, in pounds? ");
        weight = input.nextDouble();

        System.out.print("How many hours has it been since your last drink? ");
        time_since_drink = input.nextDouble();

        if(gender==1)
        {
            conversion_rate=0.73;
        }
        else
        {
            conversion_rate=0.66;
        }

        BAC=(consumed_alc*5.14/weight*conversion_rate)-.015*time_since_drink;

        if(BAC>=0.08)
        {
            answer="It is not legal for you to drive.";
        }
        else
        {
            answer="It is legal for you to drive.";
        }


        System.out.print("\n");

        BigDecimal rounding = new BigDecimal(BAC).setScale(6, RoundingMode.HALF_UP);
        double BAC_rounded = rounding.doubleValue();

        System.out.print("Your BAC is "+(BAC_rounded));
        System.out.print("\n"+(answer));



    }

}