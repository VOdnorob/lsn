package com.tasks.lsn.io;

import java.util.*;

public class Task3 {
    public void run(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Читаємо всі зв'язки і будуємо граф
        for (int i = 0; i < n; i++) {
            String[] edge = sc.nextLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Використовуємо набір для зберігання відвіданих вершин
        Set<Integer> visited = new HashSet<>();
        int numComponents = 0;

        // Проходимо по всіх вершинах і знаходимо окремі компоненти
        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                numComponents++;
                dfs(vertex, graph, visited);
            }
        }

        // Враховуємо ізольовані вершини
        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                numComponents++;
                visited.add(vertex);
            }
        }

        System.out.println(numComponents);
    }

    private void dfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited.contains(v)) {
                visited.add(v);
                for (int neighbor : graph.get(v)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
