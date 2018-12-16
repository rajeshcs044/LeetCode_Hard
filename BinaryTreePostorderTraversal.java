package com.rajesh.practice.hard.newpack;

import java.util.ArrayList;
import java.util.List;

import com.rajesh.practice.medium.TreeNode;

public class BinaryTreePostorderTraversal
{
    List<Integer> postorderList = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root)
    {
        postorder(root);
        return postorderList;
    }

    public void postorder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.val);
    }
}
