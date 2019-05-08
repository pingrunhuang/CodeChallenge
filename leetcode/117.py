
class Node(object):
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution(object):
    def connect(self, root:Node) -> Node:
        """
        :type root: Node
        :rtype: Node
        """
        if root is None:
            return None
        self.dfs(root.left, root.right)
        return root
    
    def dfs(self, left:Node, right:Node):
        if left is None or right is None:
            return
        left.next = right
        if left.left:
            if left.right:
                self.dfs(left.left, left.right)
            elif right.left:
                self.dfs(left.left, right.left)
            elif right.right:
                self.dfs(left.left, right.right)
        if left.right:
            if right.left:
                self.dfs(left.right, right.left)
            elif right.right:
                self.dfs(left.right, right.right)
        if right.left:
            if right.right:
                self.dfs(right.left, right.right)
        
    
if __name__ == "__main__":
    {"$id":"1",
    "left":{
        "$id":"2",
        "left":{"$id":"3","left":None,"next":None,"right":None,"val":4},
        "next":None,
        "right":{"$id":"4","left":None,"next":None,"right":None,"val":5},
        "val":2},
    "next":None,
    "right":{
        "$id":"5",
        "left":None,
        "next":None,
        "right":{"$id":"6","left":None,"next":None,"right":None,"val":7},
        "val":3},
    "val":1}

    {"$id":"1",
    "left":{
        "$id":"2",
        "left":{"$id":"3","left":{"$id":"4","left":None,"next":None,"right":None,"val":7},"next":None,"right":None,"val":4},
        "next":None,
        "right":{"$id":"5","left":None,"next":None,"right":None,"val":5},"val":2},
    "next":None,
    "right":{
        "$id":"6",
        "left":None,
        "next":None,
        "right":{"$id":"7","left":None,"next":None,"right":{"$id":"8","left":None,"next":None,"right":None,"val":8},"val":6},"val":3},
    "val":1}