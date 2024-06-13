package com.tasks.lsn.io;

import java.util.*;

public class Task1 {

    public void run(Scanner sc) {
        System.out.println("Enter the integers (separated by spaces):");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        TreeSet<Integer> array = new TreeSet<>();

        for (String num : inputArray) {
            array.add(Integer.parseInt(num));
        }

        System.out.println(array.toString().replace("[", "").replace("]", "").replace(",", ""));
        System.out.println("count: " + inputArray.length);
        System.out.println("distinct: " + array.size());
        System.out.println("max: " + array.last());
        System.out.println("min: " + array.first());
    }
}
