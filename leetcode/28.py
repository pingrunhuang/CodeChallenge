'''

'''

class Solution:
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if needle=='' or haystack==needle:
            return 0
        
        needle_length = len(needle)
        for i in range(len(haystack)-needle_length+1):
            if needle == haystack[i:i+needle_length]:
                return i
        return -1

if __name__ == "__main__":
    s = Solution()
    haystack = "hello"
    needle = "ll"
    print(s.strStr(haystack, needle))



        
        
