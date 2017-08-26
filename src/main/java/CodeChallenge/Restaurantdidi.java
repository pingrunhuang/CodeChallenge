package CodeChallenge;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*

某餐馆有n张桌子，每张桌子有一个参数：可容纳的最大人数a； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
输入：
输入包括m+2行。
第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。

测试用例:
4 6
12 1 4 7
11 3
3 10
35 10
5 9
12 10
6 7

对应输出应该为:

29
*/

/*
* 动态规划，最优解
* */

public class Restaurantdidi {

    static class Batch implements Comparable<Batch>{
        int people;
        int money;
        Batch(int p, int m){
            this.people = p;
            this.money = m;
        }

        // compare by the consumption of a certain customer in descending order
        public int compareTo(Batch o) {
            if (this.money > o.money)
                return -1;
            if (this.money < o.money)
                return 1;
            return 0;
        }
    }


    /*
    * brutal force
    *
    * */
    static long getMaximumRevenue(Batch[] customers, int[] tables){
        long sum = 0;
        int numOfTables = tables.length;
        int batchesOfCostumers = customers.length;
        boolean[] visited = new boolean[numOfTables];
        // 容量从小到大排序
        Arrays.sort(tables);
        // 按消费能力将目标高低从高到低排序, head（刚加入的元素）是最小的
        PriorityQueue<Batch> queue = new PriorityQueue<Batch>();
        for (int i=0;i<batchesOfCostumers;i++){
            if (customers[i].people<=tables[numOfTables-1]){
                queue.add(customers[i]);
            }
        }

        int count = 0;//用来计算是否用完了所有的桌子
        while (!queue.isEmpty()){
            Batch currentBatch = queue.poll();
            for (int i=0;i<numOfTables;i++){
                if (currentBatch.people <= tables[i] && !visited[i]){
                    sum += currentBatch.money;
                    visited[i] = true;
                    count++;
                    break;
                }
            }
            if (count == numOfTables)
                break;
        }

        return sum;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] tables = new int[n];
            Batch[] customers = new Batch[m];

            for (int i=0;i<n;i++){
                tables[i] = scanner.nextInt();
            }
            for (int i=0;i<m;i++){
                Batch customer = new Batch(scanner.nextInt(), scanner.nextInt());
                customers[i] = customer;
            }
            System.out.println(getMaximumRevenue(customers,tables));
        }
    }
}
