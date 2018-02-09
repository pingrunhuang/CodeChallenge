import unittest
from collections import deque
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def genTree(arr, i):
    '''
    input: list[int]
    output: treeNode of the root
    '''
    if len(arr)<=0:
        return None
    
    if i < len(arr):
        root = TreeNode(arr[i])
        root.left=genTree(arr,2*i+1)
        root.right=genTree(arr, 2*i+2)
        return root
        
    return None
            
def viewTree(root):
    que=deque()
    que.append(root)
    while len(que)>0:
        node =que.popleft()
        if node:
            print(node.val)
            que.append(node.left)
            que.append(node.right)

class TestCases(unittest.TestCase):
    
    def setUp(self):
        self.testCase1 = [3,9,20,None,None,15,7]

    def testGenTree(self):
        self.assertEqual(3, genTree(self.testCase1, 0).val)
    def testViewTree(self):
        root=genTree(self.testCase1, 0)
        
            
        
if __name__=='__main__':
    unittest.main()
    