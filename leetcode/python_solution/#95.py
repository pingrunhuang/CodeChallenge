'''

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

From the example above, we can tell that the sequence should be min->middle->max

Notice that how to transform the question into a recursive one: add a stopping condition

Steps:
with no memoization -> with memoization
'''
from generateBinaryTree import TreeNode, viewTreeBFS

class Solution:
    def __init__(self):
        self.dp={}
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        if n==0:
            return None
        return self.recurse(1,n)
    
    def recurse(self, start, end):
        if start == end:
            return [TreeNode(start)]
        
        result = []
        for v in range(start,end):
            tempNode = TreeNode(v)
            left_trees = self.recurse(start,v)
            right_trees = self.recurse(v+1,end)
            for l in left_trees:
                for r in right_trees:
                    tempNode.left=l
                    tempNode.right=r
                    result.append(tempNode)
        return result

if __name__=='__main__':
    soluiton = Solution()
    result = soluiton.generateTrees(3)
    for t in result:
        viewTreeBFS(t)
        

            
