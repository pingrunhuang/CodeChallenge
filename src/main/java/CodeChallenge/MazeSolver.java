package CodeChallenge;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
test case 1:
#.########
#........#
#........#
#........#
#........#
#........#
#........#
#........#
#........#
########.#
expect output:
16

test case 2:
#.########
#........#
########.#
#........#
#.########
#........#
########.#
#........#
#.######.#
########.#
expect output:
30

Implemented using BFS
* */
public class MazeSolver {

    public static boolean[][] visited;
    public static char[][] maze1;
    public static char[][] maze2;

    static class Node{
        int x;
        int y;
        int step;
        Node(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    static {
        maze1 = new char[10][10];
        maze1[0] = "#.########".toCharArray();
        maze1[1] = "#........#".toCharArray();
        maze1[2] = "#........#".toCharArray();
        maze1[3] = "#........#".toCharArray();
        maze1[4] = "#........#".toCharArray();
        maze1[5] = "#........#".toCharArray();
        maze1[6] = "#........#".toCharArray();
        maze1[7] = "#........#".toCharArray();
        maze1[8] = "#........#".toCharArray();
        maze1[9] = "########.#".toCharArray();

        maze2 = new char[10][10];
        maze2[0] = "#.########".toCharArray();
        maze2[1] = "#........#".toCharArray();
        maze2[2] = "########.#".toCharArray();
        maze2[3] = "#........#".toCharArray();
        maze2[4] = "#.########".toCharArray();
        maze2[5] = "#........#".toCharArray();
        maze2[6] = "########.#".toCharArray();
        maze2[7] = "#........#".toCharArray();
        maze2[8] = "#.######.#".toCharArray();
        maze2[9] = "#......#.#".toCharArray();
    }

    public static int bfs(char[][] maze, Node start, Node end){
        int result = 0;
        visited = new boolean[maze.length][maze[0].length];
        visited[start.x][start.y] = true;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

        while (queue != null){
            Node current_node = queue.remove();
            if (current_node.x == end.x && current_node.y == end.y)
                return current_node.step;
            for (int i=0;i<directions.length;i++){
                int next_x = current_node.x + directions[i][0];
                int next_y = current_node.y + directions[i][1];
                if (isAvailable(maze,next_x,next_y)){
                    Node next_node = new Node(next_x, next_y, current_node.step + 1);
                    queue.add(next_node);
                    visited[next_x][next_y] = true;
                }
            }
        }

        return result;
    }

    public static boolean isAvailable(char[][] maze, int x, int y){
        if ((x < maze.length && x >= 0) && (y < maze[0].length && y >= 0) && !visited[x][y] && maze[x][y] == '.')
            return true;
        return false;
    }


    @Test
    public void testMazeSolver(){
        Node start = new Node(0,1, 0);
        Node end = new Node(9, 8,0);

        Assert.assertEquals(16, bfs(maze1, start, end));
        Assert.assertEquals(30, bfs(maze2, start, end));
    }

}
