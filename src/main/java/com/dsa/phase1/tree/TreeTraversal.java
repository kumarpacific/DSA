package com.dsa.phase1.tree;

/**   TREE TRAVERSAL =>
 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 *
 * A Tree Data Structure can be traversed in following ways:
 *
 * 1. Depth First Search or DFS
 *      a. Inorder Traversal
 *      b. Preorder Traversal
 *      c. Postorder Traversal
 * 2. Level Order Traversal or Breadth First Search or BFS
 * 3. Boundary Traversal
 * 4. Diagonal Traversal
 */
public class TreeTraversal {
    public static void main(String[] args) {


        /*
        *               6
        *              /  \
        *             4    7
        *           /   \
        *          2     5
        *        /   \
        *       1     3
        *
        * in-order - Left-Center-Right - 1234567
        * pre-order - Center-Left-Right - 6421357
        * post-order - Left-Right-Center - 1325476
        * */


    }


    public void inorder(Node root){}
    public void preorder(Node root){}
    public void postorder(Node root){}
}


class Node{
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}