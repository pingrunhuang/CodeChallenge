"""
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
"""

class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) in (0, 1) or k == 0:
            return 0
        
        


if __name__ == "__main__":
    solution = Solution()
    t1 = ([2,4,1], 2)
    assert solution.maxProfit(t1[1], t1[0]) == 2
    t2 = ([3,2,6,5,0,3], 2)
    assert solution.maxProfit(t2[1], t2[0]) == 7