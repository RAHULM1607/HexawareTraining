package Day2;


import java.time.LocalDate;
import java.util.*;

// MAIN CLASS
public class InsuranceClaimsProcessing {

    // ==========================================
    // TASK 1: BINARY SEARCH TREE
    // ==========================================

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BST {
        Node root;

        // Insert a claim ID
        void insert(int data) {
            root = insertNode(root, data);
        }

        Node insertNode(Node root, int data) {

            if (root == null) {
                return new Node(data);
            }

            if (data < root.data) {
                root.left = insertNode(root.left, data);
            } else if (data > root.data) {
                root.right = insertNode(root.right, data);
            }

            // Duplicate IDs are ignored
            return root;
        }

        // Search for a claim ID
        boolean search(int data) {
            Node temp = root;

            while (temp != null) {

                if (temp.data == data) {
                    return true;
                } else if (data < temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            return false;
        }

        // Inorder: Left, Root, Right
        void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Preorder: Root, Left, Right
        void preorder(Node root) {
            if (root == null) return;

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Postorder: Left, Right, Root
        void postorder(Node root) {
            if (root == null) return;

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }


    // ==========================================
    // TASK 2: HASHING - DUPLICATE CLAIM DETECTION
    // ==========================================

    static class ClaimKey {

        String policyNumber;
        LocalDate incidentDate;

        ClaimKey(String policyNumber, LocalDate incidentDate) {

            // Ignore spaces and letter case
            this.policyNumber = policyNumber
                    .replaceAll("\\s+", "")
                    .toLowerCase();

            this.incidentDate = incidentDate;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (!(obj instanceof ClaimKey)) return false;

            ClaimKey other = (ClaimKey) obj;

            return policyNumber.equals(other.policyNumber)
                    && incidentDate.equals(other.incidentDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber, incidentDate);
        }
    }

    static class Claim {
        int claimId;
        String policyNumber;
        LocalDate incidentDate;

        Claim(int claimId, String policyNumber,
              LocalDate incidentDate) {

            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.incidentDate = incidentDate;
        }
    }

    static class DuplicateDetector {

        HashMap<ClaimKey, Claim> claims = new HashMap<>();

        void addClaim(Claim claim) {

            ClaimKey key = new ClaimKey(
                    claim.policyNumber,
                    claim.incidentDate
            );

            if (claims.containsKey(key)) {

                System.out.println(
                        "Duplicate claim detected! Claim ID: "
                                + claim.claimId
                                + " matches Claim ID: "
                                + claims.get(key).claimId
                );

            } else {

                claims.put(key, claim);

                System.out.println(
                        "Claim " + claim.claimId + " registered."
                );
            }
        }
    }


    // ==========================================
    // TASK 3: GRAPH - BFS AND DFS
    // ==========================================

    static class Graph {

        Map<String, List<String>> adj =
                new LinkedHashMap<>();

        void addEdge(String source, String destination) {

            adj.putIfAbsent(source, new ArrayList<>());
            adj.putIfAbsent(destination, new ArrayList<>());

            adj.get(source).add(destination);
        }

        // BFS - Find shortest path
        void bfsShortestPath(String start, String end) {

            if (!adj.containsKey(start) ||
                    !adj.containsKey(end)) {

                System.out.println("Stage not found.");
                return;
            }

            Queue<String> queue = new java.util.LinkedList<>();

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

            // Reconstruct shortest path
            List<String> path = new ArrayList<>();

            String current = end;

            while (current != null) {

                path.add(current);
                current = parent.get(current);
            }

            Collections.reverse(path);

            System.out.println("Shortest path: " + path);
        }

        // DFS - Detect cycles in directed graph
        boolean hasCycle() {

            Set<String> visited = new HashSet<>();

            Set<String> recursionStack = new HashSet<>();

            for (String node : adj.keySet()) {

                if (!visited.contains(node)) {

                    if (dfsCycle(node, visited, recursionStack)) {
                        return true;
                    }
                }
            }

            return false;
        }

        boolean dfsCycle(String node,
                         Set<String> visited,
                         Set<String> recursionStack) {

            visited.add(node);
            recursionStack.add(node);

            for (String neighbour : adj.get(node)) {

                if (!visited.contains(neighbour)) {

                    if (dfsCycle(neighbour,
                            visited, recursionStack)) {
                        return true;
                    }

                } else if (recursionStack.contains(neighbour)) {

                    return true;
                }
            }

            recursionStack.remove(node);

            return false;
        }
    }


    // ==========================================
    // TASK 4: SLIDING WINDOW
    // LONGEST RUN OF DAYS WITH MORE THAN 100 CLAIMS
    // ==========================================

    static int longestRun(int[] dailyClaims) {

        int maxLength = 0;
        int currentLength = 0;

        for (int count : dailyClaims) {

            if (count > 100) {

                currentLength++;

                maxLength = Math.max(
                        maxLength, currentLength
                );

            } else {

                currentLength = 0;
            }
        }

        return maxLength;
    }


    // ==========================================
    // TASK 5: TWO POINTERS
    // MERGE TWO SORTED CLAIM LISTS
    // ==========================================

    static int[] mergeSortedLists(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] result = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements from both arrays
        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {

                result[k] = arr1[i];
                i++;

            } else {

                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from first array
        while (i < n) {

            result[k] = arr1[i];

            i++;
            k++;
        }

        // Copy remaining elements from second array
        while (j < m) {

            result[k] = arr2[j];

            j++;
            k++;
        }

        return result;
    }


    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        // TASK 1: BST
        System.out.println("===== TASK 1: BST =====");

        BST bst = new BST();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(50); // Duplicate ignored

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);

        System.out.println("\nSearch 60: " + bst.search(60));
        System.out.println("Search 90: " + bst.search(90));


        // TASK 2: HASHING
        System.out.println("\n\n===== TASK 2: HASHING =====");

        DuplicateDetector detector = new DuplicateDetector();

        detector.addClaim(new Claim(
                101, "POLICY123",
                LocalDate.of(2026, 11, 10)
        ));

        detector.addClaim(new Claim(
                102, "policy123",
                LocalDate.of(2026, 11, 10)
        ));

        detector.addClaim(new Claim(
                103, "POLICY 123",
                LocalDate.of(2026, 11, 11)
        ));

        detector.addClaim(new Claim(
                104, "POLICY123",
                LocalDate.of(2026, 11, 10)
        ));


        // TASK 3: GRAPH
        System.out.println("\n===== TASK 3: GRAPH =====");

        Graph graph = new Graph();

        graph.addEdge("Registration", "Assessment");
        graph.addEdge("Assessment", "Surveyor");
        graph.addEdge("Surveyor", "Settlement");
        graph.addEdge("Assessment", "Settlement");

        graph.bfsShortestPath(
                "Registration", "Settlement"
        );

        System.out.println(
                "Cycle detected: " + graph.hasCycle()
        );

        // Add a backward edge to demonstrate cycle detection
        graph.addEdge("Settlement", "Assessment");

        System.out.println(
                "Cycle after adding backward edge: "
                        + graph.hasCycle()
        );


        // TASK 4: SLIDING WINDOW
        System.out.println("\n===== TASK 4: SLIDING WINDOW =====");

        int[] dailyClaims = {
                120, 150, 130, 90, 110, 140, 160, 170, 80
        };

        System.out.println(
                "Longest consecutive days above 100: "
                        + longestRun(dailyClaims)
        );


        // TASK 5: TWO POINTERS
        System.out.println("\n===== TASK 5: TWO POINTERS =====");

        int[] office1 = {10, 20, 40, 60};
        int[] office2 = {15, 25, 35, 50};

        int[] merged = mergeSortedLists(office1, office2);

        System.out.println(
                "Merged sorted list: "
                        + Arrays.toString(merged)
        );


        // EMPTY INPUT TEST
        System.out.println("\n===== EMPTY INPUT TEST =====");

        System.out.println(
                "Empty BST search: " + new BST().search(10)
        );

        System.out.println(
                "Empty sliding window: "
                        + longestRun(new int[]{})
        );

        System.out.println(
                "Empty merge: "
                        + Arrays.toString(
                        mergeSortedLists(
                                new int[]{},
                                new int[]{}
                        )
                )
        );
    }
}

