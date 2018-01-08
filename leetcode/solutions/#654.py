
'''
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

'''

class Solution:
    class TreeNode:
        def __init__(self, value, rNode, lNode):
            self.value = value
            self.rNode = rNode
            self.lNode = lNode
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if len(nums)==0:
            return 
        if  len(nums) == 1:
            return self.TreeNode(nums[0], None, None)
        maxValueIndex = 0
        maxValue = nums[maxValueIndex]
        for i,v in enumerate(nums):
            if v>maxValue:
                maxValueIndex=i
                maxValue=v
        leftTree = self.constructMaximumBinaryTree(nums[0:maxValueIndex])
        rightTree = self.constructMaximumBinaryTree(nums[maxValueIndex+1:len(nums)])
        return self.TreeNode(maxValue, rightTree, leftTree)
    


if __name__ == '__main__':
    test_case1 = [3,2,1,6,0,5]
    
    solution = Solution()
    result1 = solution.constructMaximumBinaryTree(test_case1)
    print(result1.rNode.lNode.value)
