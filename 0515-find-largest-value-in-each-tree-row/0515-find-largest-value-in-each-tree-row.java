class Solution {
    public void largestValuesDFS(TreeNode root, int level, List<Integer> maxLst) {
        if(root == null) return;

        if(level == maxLst.size()) {
            maxLst.add(root.val);
        }

        maxLst.set(level, Math.max(root.val, maxLst.get(level)));

        largestValuesDFS(root.left, level + 1, maxLst);
        largestValuesDFS(root.right, level + 1, maxLst);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxLst = new ArrayList<>();
        largestValuesDFS(root, 0, maxLst);
        return maxLst;
    }
}