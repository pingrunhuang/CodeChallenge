'''
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

corner case
'''
import math

class Solution3:
    '''
    Manacher's algo
    '''
    def longestPalindrome(self, s):
        pass

class Solution2:
    '''
    With dp
    '''
    def longestPalindrome(self,s):
        pass    

class Solution:

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s)==0 or len(s)==1:
            return s
        
        start_ptr = 0
        end_ptr = 0
        # there exists 2*n-1 possible position for the center index
        for central_index in range(len(s)):
            len1 = self.expand(s, central_index, central_index)
            len2 = self.expand(s, central_index, central_index+1)
            max_len = max(len1, len2)

            if max_len > end_ptr-start_ptr:
                start_ptr = central_index - int((max_len-1)/ 2)
                end_ptr = central_index + int(max_len / 2)
        return s[start_ptr:end_ptr+1]

    def expand(self, s, left, right):
        while left >=0 and right<len(s) and s[left]==s[right]:
            left-=1
            right+=1
        return right - left - 1

if __name__ == '__main__':
    solution = Solution()
    t1="babad"
    t2="cbbd"
    t3="bb"
    print(solution.longestPalindrome(t3))