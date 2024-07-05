package com.tasks.lsn.io;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public void run(Scanner scanner) {
        System.out.println("Please enter the numbers in one line:");
        String inputLine = scanner.nextLine().trim();

        if (inputLine.isEmpty()) {
            System.out.println("No input provided.");
            return;
        }

        List<Integer> numbers = Arrays.stream(inputLine.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<int[]> pairs = findPairs(numbers, 13);

        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    public List<int[]> findPairs(List<Integer> numbers, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : numbers) {
            int complement = targetSum - number;

            int complementCount = frequencyMap.getOrDefault(complement, 0);

            while (complementCount > 0) {
                pairs.add(new int[]{Math.min(number, complement), Math.max(number, complement)});
                complementCount--;
            }

            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        pairs.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        return pairs;
    }
}
