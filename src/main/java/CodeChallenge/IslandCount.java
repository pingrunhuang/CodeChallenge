package CodeChallenge;

/*
4 5
11000
11000
00100
00011

return 3
* */

import java.util.*;

public class IslandCount {
    static List<Point> points;
    static char[][] map;
    static int count = 0;

    static class Island{
        List<Point> points;

    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean isValidPoint(Point point){
        if (point.x < map.length && point.x > 0){
            if (point.y < map[0].length && point.y > 0){
                return true;
            }
        }
        return false;
    }


    //TODO
    static boolean isIsland(Point point){
        boolean isIsland = false;
        Point up = new Point(point.x,point.y-1);
        Point down = new Point(point.x, point.y+1);
        Point left = new Point(point.x-1, point.y);
        Point right = new Point(point.x+1, point.y);

        if(isValidPoint(point) && map[point.x][point.y] == '1'){
            points.add(point);
            isIsland = true;
        }
//        if (isValidPoint())
//
//        if ()

        return isIsland;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        map = new char[n][m];
        for (int i=0;i<n;i++){
            String line = scanner.next();
            for (int j=0;j<m;j++){
                map[i][j] = line.charAt(j);
            }
            System.out.println();
        }

        points = new ArrayList<Point>();
    }
}
