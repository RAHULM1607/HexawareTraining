package Day2Assignment;
import java.util.*;

public class Task3Graph {
    static class Graph {
        Map<String, List<String>> adj = new LinkedHashMap<>();

        void addEdge(String source, String destination) {
            adj.putIfAbsent(source, new ArrayList<>());
            adj.putIfAbsent(destination, new ArrayList<>());
            adj.get(source).add(destination);
        }

        void bfsShortestPath(String start, String end) {
            if (!adj.containsKey(start) || !adj.containsKey(end)) {
                System.out.println("Stage not found.");
                return;
            }

            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Map<String, String> parent = new HashMap<>();

            queue.add(start);
            visited.add(start);
            boolean found = false;

            while (!queue.isEmpty()) {
                String current = queue.poll();

                if (current.equals(end)) {
                    found = true;
                    break;
                }

                for (String neighbour : adj.get(current)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        parent.put(neighbour, current);
                        queue.add(neighbour);
                    }
                }
            }

            if (!found) {
                System.out.println("No path exists.");
                return;
            }

            List<String> path = new ArrayList<>();
            String current = end;

            while (current != null) {
                path.add(current);
                current = parent.get(current);
            }

            Collections.reverse(path);
            System.out.println("Shortest path: " + path);
        }

        boolean hasCycle() {
            Set<String> visited = new HashSet<>();
            Set<String> recursionStack = new HashSet<>();

            for (String node : adj.keySet()) {
                if (!visited.contains(node)) {
                    if (dfsCycle(node, visited, recursionStack)) return true;
                }
            }
            return false;
        }

        boolean dfsCycle(String node, Set<String> visited,
                         Set<String> recursionStack) {
            visited.add(node);
            recursionStack.add(node);

            for (String neighbour : adj.get(node)) {
                if (!visited.contains(neighbour)) {
                    if (dfsCycle(neighbour, visited, recursionStack)) return true;
                } else if (recursionStack.contains(neighbour)) {
                    return true;
                }
            }

            recursionStack.remove(node);
            return false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Registration", "Assessment");
        graph.addEdge("Assessment", "Surveyor");
        graph.addEdge("Surveyor", "Settlement");
        graph.addEdge("Assessment", "Settlement");

        graph.bfsShortestPath("Registration", "Settlement");
        System.out.println("Cycle detected: " + graph.hasCycle());

        graph.addEdge("Settlement", "Assessment");
        System.out.println("Cycle after adding backward edge: " + graph.hasCycle());
    }
}
