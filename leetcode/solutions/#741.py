
'''
Conditions:
    1. col = cur_steps - row
    2. reward[row, col] = max(reward[row+1][col]-grid[row+1][col], reward[row][col+1]-grid[row][col+1])
    3. reward[0,0]=0

'''

class Solution(object):

    def cherryPickup(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        N = len(grid)
        # how to define negative infinitive in python
        # float('inf') for infinitive
        NINF = float('-inf')
        # note here how to write fast check statement nested inside a generator!!!!
        accumulated_reward = [[x if x!=-1 else NINF for x in y] for y in grid]
        for e in accumulated_reward:
            e.append(NINF)
        accumulated_reward.append([NINF]*(N+1))
        
if __name__ == '__main__':
    test_case1 = [
        [1,1,-1],
        [1,0,-1],
        [1,1,1]
    ]
    solution = Solution()
    solution.cherryPickup(test_case1)

    test_case2 = [
        [1,1,1,0,0],
        [0,0,1,0,1],
        [1,0,1,0,0],
        [0,0,1,0,0],
        [0,0,1,1,1]
    ]
