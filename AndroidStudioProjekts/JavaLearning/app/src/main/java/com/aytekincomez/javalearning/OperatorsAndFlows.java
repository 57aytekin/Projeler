package com.aytekincomez.javalearning;

/**
 * Created by aytek on 1.09.2017.
 */

public class OperatorsAndFlows {

    public static void main(String[] args) {

        int day = 1;
        String dayString = "";

        //Switch
        switch (day) {
            case 1 :
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            default:
                dayString = "Sunday";
                break;
        }


    }
}
