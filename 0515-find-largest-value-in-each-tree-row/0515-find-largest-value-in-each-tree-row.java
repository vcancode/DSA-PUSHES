class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int maximum = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                maximum = Math.max(maximum, node.val);

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }

            res.add(maximum);
        }

        return res;
    }
}