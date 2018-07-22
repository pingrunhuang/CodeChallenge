'''
Description:
Grid and matrix problem:
Given a matrix filled with numbers where each number represent a color, return the maximum number of grids that are connected.
'''

class Solution1:
    '''
    Does not work: even you create a boarder with 0 representing the boarder, when you come across the grid where 
        more than 1 directions has the same color, 
        if you change the color to other number, you will end up just searching for one direction. 
        if you don't change the color, you will end up maximum recursion depth.
    Solution one extend the existing matrix with boarder filled with 0 
    '''
    def dfs(self, i, j, matrix):
        result = 1
        # matrix[i][j]=-1
        if 0<=i<len(matrix) and 0<=j<len(matrix[i]) and matrix[i][j]!=-1:
            # right traversal
            if 0<=i+1<len(matrix) and matrix[i][j]==matrix[i+1][j]:
                result += self.dfs(i+1, j, matrix)
                matrix[i+1][j]=-1
            # down traversal
            if 0<=j+1<len(matrix[i]) and matrix[i][j]==matrix[i][j+1]:
                # matrix[i][j]=-1
                result += self.dfs(i, j+1, matrix)
                matrix[i][j+1]
            # left traversal
            if 0<=i-1<len(matrix) and matrix[i][j]==matrix[i-1][j]:
                # matrix[i][j]=-1
                result += self.dfs(i-1, j, matrix)
                matrix[i-1][j]=-1
            # up traversal
            if 0<=j-1<len(matrix[i]) and matrix[i][j]==matrix[i][j-1]:
                # matrix[i][j]=-1
                result += self.dfs(i,j-1,matrix)
                matrix[i][j-1]=-1
        matrix[i][j]=-1
        return result

    def maxNumOfNeighbour(self, matrix):
        result = 0
        for i,_ in enumerate(matrix):
            temp_result = 0
            for j,_ in enumerate(matrix[i]):
                temp_result += self.dfs(i,j,matrix)
                if temp_result>result:
                    result = temp_result
        return result


def matrix2Grid(matrix):
    '''
    Transform the matrix element into the form of tuple (x,y)
    x: color
    y: hasTraverse
    '''
    return [[[col, 0] for col in row] for row in matrix]

class Solution2:
    def dfs1(self, i, j, matrix):
        result = 0
        # margin situation
        if 0<=i<len(matrix) and 0<=j<len(matrix[i]) and matrix[i][j][1]!=1:
            result+=1
            matrix[i][j][1] = 1
            # left
            if j-1>=0 and matrix[i][j][0]==matrix[i][j-1][0]:
                result += self.dfs1(i, j-1, matrix)
            # right
            if j+1<len(matrix[i]) and matrix[i][j][0]==matrix[i][j+1][0]:
                result += self.dfs1(i, j+1, matrix)
            # up
            if i-1>=0 and matrix[i][j][0]==matrix[i-1][j][0]:
                result += self.dfs1(i-1, j, matrix)
            # down
            if i+1<len(matrix) and matrix[i][j][0]==matrix[i+1][j][0]:
                result += self.dfs1(i+1, j, matrix)
            # matrix[i][j]=-1
        return result

    def solve(self, matrix):
        maximumBlocks = 0
        for i,_ in enumerate(matrix):
            for j,_ in enumerate(matrix[i]):
                result = self.dfs1(i, j, matrix)
                # update the maximum number of linked blocks
                if maximumBlocks < result:
                    maximumBlocks = result
        return maximumBlocks

if __name__ == "__main__":
    # test1 = [
    #     [1,2,3,2],
    #     [1,2,2,2],
    #     [3,1,2,1],
    #     [1,1,2,1]
    # ]
    # solution = Solution1()
    # print("test 1: ",solution.maxNumOfNeighbour(test1))
    test2 = [
        [1,2,3,2],
        [1,2,2,2],
        [3,1,2,1],
        [1,1,2,1]
    ]
    test2 = matrix2Grid(test2)
    solution = Solution2()
    print("test 2: ", solution.solve(test2))


    
