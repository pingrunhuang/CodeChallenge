from collections import deque

'''
In order to print line by line, the answer is to maintain 2 pointers pointing to the current line's end and the next line's end
'''

class TreeNode(object):
    def __init__(self, value):
        self.val = value
        self.left = None
        self.right = None

def printTree(root):
    if root==None:
        return
    
    queue = deque()
    queue.append(root)
    cur_end_node = root
    next_end_node = root
    while len(queue)!=0:
        cur_node = queue.popleft()
        if cur_node.left:
            next_end_node=cur_node.left
            queue.append(cur_node.left)
        if cur_node.right:
            next_end_node=cur_node.right
            queue.append(cur_node.right)

        if cur_end_node==cur_node:
            cur_end_node = next_end_node
            print(cur_node.val)
        else:
            print(cur_node.val, end=' ')
        


if __name__ == "__main__":
    tree2=TreeNode(2)
    tree2.right=TreeNode(3)
    tree2.right.right=TreeNode(7)
    tree2.left=TreeNode(1)
    tree2.left.right=TreeNode(4)
    printTree(tree2)