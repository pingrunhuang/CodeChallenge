'''
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

TODO Could not solve the corner case 
'''
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
        return [lowest, highest]
                
if __name__ == "__main__":
    s = Solution()
    nums = [5,7,7,8,8,10]
    print(s.searchRange(nums, 8))
    print(s.searchRange(nums, 6))
    nums = [2,2]
    print(s.searchRange(nums, 2))
    nums = [1,4]
    print(s.searchRange(nums,4))
    nums=[1,2,5,5,5,9]
    print(s.searchRange(nums, 5))