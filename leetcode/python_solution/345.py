"""345. Reverse Vowels of a String
"""

class Solution:
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = "vowels"
        head = 0
        tail = len(s)-1
        result = list(s)
        while head<tail:
            if s[tail] not in vowels:
                result[tail] = s[tail]
                tail-=1
            if s[head] not in vowels:
                result[head] = s[head]
                head+=1
            if s[head] in vowels and s[tail] in vowels:
                result[head] = s[tail]
                result[tail] = s[head]
                head+=1
                tail-=1
        return str(result)

if __name__ == "__main__":
    solution = Solution()
    t1 = "hello"
    print(solution.reverseVowels(t1))
    t2 = "leetcode"
    print(solution.reverseVowels(t2))