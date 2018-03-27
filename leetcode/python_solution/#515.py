'''
515. Find Largest Value in Each Tree Row

BST
'''

from generateBinaryTree import TreeNode, genTree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []

        queue=[root]
        result=[]
        while len(queue)!=0:
            result.append(max(x.val for x in queue if x.val is not None))
            temp_queue = []
            for node in queue:
                if node.left!=None:
                    temp_queue.append(node.left)
                if node.right!=None:
                    temp_queue.append(node.right)
            queue=temp_queue
        return result

    def largestValues2(self, root):
        row=[root]
        result=[]
        while any(row):
            result.append(max(x.val for x in row))
            # this is not valide, the intereter could not find the definition of node
            # row = [kid for kid in (node.left, node.right) if kid for node in row ]
            row = [ kid for node in row for kid in (node.left, node.right) if kid ]

        return result

if __name__=="__main__":
    solution = Solution()
    t1=[1,3,2,5,3,None,9]
    root1=genTree(t1,0)
    print(solution.largestValues1(root1))
