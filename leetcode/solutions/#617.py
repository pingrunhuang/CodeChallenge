'''
You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, 
then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree. 


Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

Summary:
Dealing with binary tree could be achieved by recursion or stack method
'''

from collections import deque
class TreeNode:
    def __init__(self, value, lNode, rNode):
        self.value = value
        self.rNode = rNode
        self.lNode = lNode

class Solution:
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1==None:
            return t2
        if t2==None:
            return t1
        t1.value=t1.value+t2.value

        t1.lNode=self.mergeTrees(t1.lNode,t2.lNode)
        t1.rNode=self.mergeTrees(t1.rNode,t2.rNode)
        return t1

    def mergeTreesWithQueue(self, t1, t2):
        queue=deque()
        if t1 == None:
            return t2
        if t2 == None:
            return t1
        queue.append((t1, t2))
        result_tree = t1
        while len(queue)!=0:
            cur_node = queue.popleft()
            result_tree
            if cur_node[0].rNode != None  :
                pass


        

    def bfs(self, root):
        queue = deque()
        queue.append(root)
        while len(queue)!=0:
            current_node = queue.popleft()
            if current_node.lNode!=None:
                queue.append(current_node.lNode)
            if current_node.rNode!=None:
                queue.append(current_node.rNode)
            print(str(current_node.value)+ '->', end=' ')


if __name__=='__main__':
    solution = Solution()
    l = TreeNode(5, None, None)
    l = TreeNode(3, l, None)
    r = TreeNode(2, None, None)
    tree1 = TreeNode(1, l, r)
    
    r=TreeNode(4, None, None)
    l=TreeNode(1, None, r)
    r=TreeNode(7,None, None)
    r=TreeNode(3, None, r)
    tree2=TreeNode(2, l, r)

    m=solution.mergeTrees(tree1,tree2)
    solution.bfs(m)