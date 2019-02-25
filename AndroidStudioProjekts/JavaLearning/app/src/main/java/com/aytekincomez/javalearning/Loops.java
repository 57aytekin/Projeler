package com.aytekincomez.javalearning;

/**
 * Created by aytek on 1.09.2017.
 */

public class Loops {

    public static void main(String[] args) {

        //For Loop

        int[] myNumbers = {12, 15, 18, 21, 24};

        for(int i=0; i<myNumbers.length; i++) {
            int y = myNumbers[i] / 3 * 5;
            //System.out.println(y);
        }
        for (int number : myNumbers) {
            int z = number / 3 * 5;
            //System.out.println(z);
        }

        //While
        int j = 1;
        while(j < 10) {
            int z = j * 10;
            j++;
            System.out.println(z);
        }


    }
}
