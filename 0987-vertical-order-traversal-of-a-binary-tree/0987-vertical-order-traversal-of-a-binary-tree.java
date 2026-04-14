import java.util.*;

class Solution {

    class Node {
        TreeNode node;
        int row, col;

        Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Node> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            list.add(temp);

            if (temp.node.left != null)
                queue.offer(new Node(temp.node.left, temp.row + 1, temp.col - 1));

            if (temp.node.right != null)
                queue.offer(new Node(temp.node.right, temp.row + 1, temp.col + 1));
        }

        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.node.val - b.node.val;
        });

        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (Node n : list) {
            map.putIfAbsent(n.col, new ArrayList<>());
            map.get(n.col).add(n.node.val);
        }

        result.addAll(map.values());
        return result;
    }
}