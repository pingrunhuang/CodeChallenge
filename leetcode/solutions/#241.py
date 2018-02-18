

'''

TODO: DP version
'''

class Solution:
    def operation(self, a, b, opt):
        if opt=='+':
            return a+b
        elif opt=='-':
            return a-b
        elif opt=='*':
            return a*b
        
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        result = []
        if input.isdigit():
            return [int(input)]

        for i, v in enumerate(input):
            if v == '+' or v == '-' or v == '*':
                result_left = self.diffWaysToCompute(input[:i])
                result_right = self.diffWaysToCompute(input[i+1:])
                for x1 in result_left:
                    for x2 in result_right:
                        result.append(self.operation(x1, x2, v))
        return result
         
        

if __name__=='__main__':
    solution = Solution()
    testCase1 = "2-1-1"
    testCase2 = "2*3-4*5"
    print(solution.diffWaysToCompute(testCase1))
    print(solution.diffWaysToCompute(testCase2))