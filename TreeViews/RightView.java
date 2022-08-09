package TreeViews;

//Java program to print left view of Binary
//Tree
import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
 
// A Binary Tree Node
class Node {
    int data;
    Node left, right;
    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
 
public class RightView{
    Node root;
 
    // function to print Right view of
    // binary tree
    void rightView(Node root)
    {
        if (root == null) {
            return;
        }
 
        Queue<Node> q = new LinkedList<>();
        q.add(root);
 
        while (!q.isEmpty()) {
 
           
            int n = q.size();
 
          
            for (int i = 1; i <= n; i++) {
                Node curr = q.poll();
 
               
                if (i == n) {
                    System.out.print(curr.data + " ");
                }
 
              
                if (curr.left != null) {
                    q.add(curr.left);
                }
 
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    
    
    public static void rightView(Node root,List<Integer> res,int currDepth) {
    	if(root == null) return;
    	if(currDepth == res.size()) {
    		res.add(root.data);
    	}
    	rightView(root.right, res, currDepth+1);
    	rightView(root.left, res, currDepth+1);
    }
 
    // Driver code
    public static void main(String[] args)
    {
 
        // Let's construct the tree as
        // shown in example
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
 
        tree.rightView(tree.root);
    }
}
 
// This code is contributed by Biswajit Rajak

//This code is contributed by
//Manne SreeCharan

