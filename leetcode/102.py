# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        result = []
        p1 = root
        p2 = root
        while p1:
            if p1.right: p2 = p1.right
            elif p2.left: p2 = p2.left
            