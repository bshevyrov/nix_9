package ua.com.alevel.secondlevel;

public class BinaryTree {

    int counter;
    int maxCounter;

    private void findMaxLength(TreeNode treeNode) {
        if (treeNode.left != null) {
            counter++;
            findMaxLength(treeNode.left);
        }
        if (treeNode.right != null) {
            counter++;
            findMaxLength(treeNode.right);
        }
        if (counter > maxCounter) {
            maxCounter = counter;
        }
        counter--;
    }

    private void add(TreeNode treeNode, int value) {
        if (treeNode.val <= value) {
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(value);
            } else {
                add(treeNode.left, value);
            }
        } else {
            if (treeNode.right == null) {
                treeNode.right = new TreeNode(value);
            } else {
                add(treeNode.right, value);
            }
        }
    }

    public void run(int[] str) {
        TreeNode treeNode = new TreeNode(str[0]);
        for (int x : str) {
            add(treeNode, x);
        }
        findMaxLength(treeNode);
        System.out.println("max depth:" + maxCounter);
    }
}
