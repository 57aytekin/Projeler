package com.aytekincomez.javalearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by aytek on 1.09.2017.
 */

public class Arrays {

    public static void main(String[] args) {
        //Arrays

        String[] myArray = new String[3];
        myArray[0] = "Ali";
        myArray[1] = "Veli";
        myArray[2] = "Ayşe";
        System.out.println(myArray[0]);
        int[] myNumberArray = {10,20,30,40,50};
        System.out.println(myNumberArray[2]);

        //List

        ArrayList<String> myMusician = new ArrayList<String>();
        myMusician.add("ALi");
        myMusician.add("Veli");
        myMusician.add(1, "Mehmet");
        myMusician.add("Rob");
        System.out.println(myMusician.get(0));
        System.out.println(myMusician.get(1));
        System.out.println(myMusician.get(2));
        System.out.println(myMusician.get(3));


        //Set

        HashSet<String> mySet = new HashSet<String>();
        mySet.add("Rob");
        System.out.println(mySet.size());

        //Map

        HashMap<String, String> myHashMap = new HashMap<String, String >();
        myHashMap.put("name", "James");
        myHashMap.put("instrument", "Guitar");
        System.out.println(myHashMap.get("name"));
    }
}
