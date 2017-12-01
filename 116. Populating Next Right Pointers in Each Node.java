/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;

        TreeLinkNode start = root;
        TreeLinkNode current = root;
        while(start != null) {
            current = start;
            while(current != null) {
                if(current.left != null) {
                    current.left.next = current.right;
                }
                if(current.right != null) {
                    if(current.next != null)current.right.next = current.next.left;
                    else current.right.next = null;
                }
                current = current.next;
            }
            start = start.left;
        }
    }
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;

        if(root.left != null)root.left.next = root.right;
        if(root.right != null) {
            if(root.next != null)root.right.next = root.next.left;
            else root.right.next = null;
        }
        connect(root.left);
        connect(root.right);
    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;

        Queue<TreeLinkNode> queue = new LinkedList<>();

        queue.offer(root);
        int size = queue.size();


        while(!queue.isEmpty()) {
            size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeLinkNode node = queue.poll();
                if(node.left != null){
                    node.left.next = node.right;
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    if(node.next != null)node.right.next = node.next.left;
                    else node.right.next = null;
                    queue.offer(node.right);
                }
            }
        }

    }
}
