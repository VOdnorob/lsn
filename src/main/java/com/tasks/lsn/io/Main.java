package com.tasks.lsn.io;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        task1.run(sc);
        System.out.println("Task 1: was end");
        task2.run(sc);
        System.out.println("Task 2: was end");
        task3.run(sc);
        System.out.println("Task 3: was end");
    }
}