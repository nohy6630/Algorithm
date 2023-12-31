import java.util.*;

public class Solution {
    class Node {
        Node parent = null;    
        long max;

        public Node(long value) {
            max = value;
        }

        public long max() {
            return find().max;
        }

        public void union(Node o) {
            if (find() == o.find())
                return;
            Node root1 = find();
            Node root2 = o.find();
            
            root2.parent = root1;
            root1.max = root2.max = Math.max(root1.max, root2.max);
        }
       
        private Node find() {
            if (parent == null)
                return this;
            return parent = parent.find();
        }
    }
       
    public long[] solution(long k, long[] roomNumbers) {
        List<Long> assigned = new ArrayList<>();
       
        Map<Long, Node> nodes = new HashMap<>();
        for (long number : roomNumbers) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() + 1;
            }
       
            Node node = new Node(number);
            nodes.put(number, node);
            if (nodes.containsKey(number - 1)) {
                node.union(nodes.get(number - 1));
            }
            if (nodes.containsKey(number + 1)) {
                node.union(nodes.get(number + 1));
            }
       
            assigned.add(number);
        }
       
        return assigned.stream().mapToLong(Long::longValue).toArray();
    }
}
