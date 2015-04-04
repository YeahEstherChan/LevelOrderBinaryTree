package com.eco;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * 
 *
 */

public class LevelOrderBinaryTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public List<Integer> rightSideView(TreeNode root) {
	    	List<Integer> show=new ArrayList<Integer>();
	    	Queue<TreeNode> save=new LinkedList<TreeNode>();
	    	int i;
	    	if(root==null) return show;
	    	save.offer(root);
	    	while(save.isEmpty()!=true)
	    	{
	    		int size=save.size();
	    		for(i=0;i<size;i++)//不能使用for(i=0;i<save.size();i++)即每次循环都重新计算新的队列长度
	    		{
	    			TreeNode tmp=save.poll();
	    			if(i==0)//由于先入队的始终是该层最右边节点，所以只需将该节点显示出来即可
	    			{
	    				show.add(tmp.val);
	    			}
	    			if(tmp.right!=null)
	    			{
	    				save.offer(tmp.right);
	    			}
	    			if(tmp.left!=null)
	    			{
	    				save.offer(tmp.left);
	    			}
	    		}
	    	}
	    	
	        return show;
	    }
}
/**
 *     public List<Integer> rightSideView(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;

        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }

        }
        return result;
    }
 */

