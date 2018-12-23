import unittest
from collections import deque
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def genTree(arr):
    from collections import deque
    '''
    input: list[int]
    output: treeNode of the root
    the binary tree should always with length 2^k
    '''
    if len(arr)<=0:
        return None
    def helper(i):
        if i<len(arr):
            if arr[i] is None:
                return None
            else:
                root = TreeNode(arr[i])    
                root.left=helper(2*i+1)
                root.right=helper(2*i+2)
                
                return root
    return helper(0)
            
def viewTreeBFS(root):
    que=deque()
    que.append(root)
    cur_end_node = root
    next_end_node = root
    cur_node = root
    while len(que)>0:
        cur_node =que.popleft()
        if cur_node.left!=None:
            next_end_node=cur_node.left
            que.append(cur_node.left)
        if cur_node.right!=None:
            next_end_node=cur_node.right
            que.append(cur_node.right)
        if cur_node==cur_end_node:
            cur_end_node=next_end_node
            print(cur_node.val)
        else:
            print(cur_node.val, end=' ')

class TestCases(unittest.TestCase):
    
    def setUp(self):
        self.testCase1 = [3,9,20,None,None,15,7]
        self.testCase2 = [1,None, 2, None, None, 3, None]
    def testGenTree(self):
        self.assertEqual(3, genTree(self.testCase1).val)
        viewTreeBFS(genTree(self.testCase2))
    def testViewTree(self):
        root=genTree(self.testCase1)
        
            
        
if __name__=='__main__':
    unittest.main()
    