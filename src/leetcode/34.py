'''
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

TODO Could not solve the corner case 
'''
from utils import assertion_print

class Solution:
    def binarySearchLowest(self, nums, left, right, target):
        if left==right:
            return left
        while left<right:
            mid = left+(right-left)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]<target:
                left=mid+1
            else:
                right=mid
        return right

    def binarySearchHighest(self, nums, left, right, target):
        if left==right:
            return left
        while left<right:
            mid = left+(right-left)//2
            if nums[mid]==target:
                return mid if nums[mid]!=nums[mid+1] else mid+1
            elif nums[mid]<target:
                left=mid+1
            else:
                right=mid
        return left

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums)==0:
            return [-1,-1]
        if len(nums)==1:
            if nums[0]==target:
                return [0,0]
            else:
                return [-1,-1]
        l = 0
        r = len(nums)-1
        highest = -1
        lowest = -1
        while l<r:
            mid = l + (r-l)//2
            if nums[mid]==target:
                lowest = self.binarySearchLowest(nums, l, mid, target)
                highest = self.binarySearchHighest(nums, mid, r, target)
                return [lowest, highest]
            elif nums[mid]<target:
                l = mid+1
            else:
                r = mid
        if nums[l]==target and nums[r]==target:
            lowest = l
            highest = r
        return [lowest, highest]

    def run(self):
        nums = [5,7,7,8,8,10]
        assertion_print(self.searchRange(nums, 8), [3,4])
        assertion_print(self.searchRange(nums, 6), [-1,-1])
        nums = [2,2]
        assertion_print(self.searchRange(nums, 2),[0,1])
        nums = [1,4]
        assertion_print(self.searchRange(nums, 4), [1,1])
        nums=[1,2,5,5,5,9]
        assertion_print(self.searchRange(nums, 5), [2,4])
        nums = [0,0,0,1,2,3]
        assertion_print(self.searchRange(nums, 0), [0,2])
    

if __name__ == "__main__":
    s = Solution()
