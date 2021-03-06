'''
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below. 
Note:

    You may use one character in the keyboard more than once.
    You may assume the input string will only contain letters of alphabet.

'''
class Solution:
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        words_in_rows={
            'q':1, 'w':1, 'e':1, 'r':1, 't':1, 'y':1, 'u':1, 'i':1, 'o':1, 'p':1,
            'a':2, 's':2, 'd':2, 'f':2, 'g':2, 'h':2, 'j':2, 'k':2, 'l':2,
            'z':3, 'x':3, 'c':3, 'v':3, 'b':3, 'n':3, 'm':3
        }
        result=[]
        for word in words:
            row=words_in_rows[word[0].lower()]
            is_in_the_same_row=True
            for c in word:
                if words_in_rows[c.lower()]!=row:
                    is_in_the_same_row=False
                    break
            if is_in_the_same_row:
                result.append(word)
        return result
                
                    
                



if __name__=='__main__':
    solution=Solution()
    testCase1=["Hello", "Alaska", "Dad", "Peace"]
    print(solution.findWords(testCase1))    