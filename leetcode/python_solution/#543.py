'''
diameter of binary:
find the longest path between 2 nodes

BST
'''

from generateBinaryTree import genTree

class Solution:
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root==None:
            return 0

        self.deepest_path=0
        def dfs(node):
            if node==None:
                return 0
            left_depth = dfs(node.left)
            right_depth = dfs(node.right)
            self.deepest_path = max(self.deepest_path, left_depth+right_depth+1)
            return 1+max(left_depth, right_depth)
        
        dfs(root)
        return self.deepest_path-1
        

if __name__=="__main__":
    solution = Solution()
    t1 = genTree([1, 2, 3, 4, 5, None, None], 0)
    print(solution.diameterOfBinaryTree(t1))
    t2 = genTree([1], 0)
    print(solution.diameterOfBinaryTree(t2))
