package DataStructure;

/*
* Problem description:
* Suppose we have N items and a sack that can contain things that weight W maximum.
* For the i item, w[i] is the weight and v[i] is the value of this item.
* How many items can we put in the sack so that the value of items contained in the sack can go to the max?
* (This is just the basic prototype supposing the num of each item is either 0 or 1)
* (There is another transformation saying the num of each item is less then b[j])
* Transform equation:
* f(i,j) means the total value of items from 1 to i with a sack that can contain weight of j.
*  f(i,j) = Max{ f(i-1,j-Wi)+Pi( j >= Wi ),  f(i-1,j) }
*
* basically, there are 2 ways of solving this problem.
* The first one might be using a matrix.
* The second one might be using recursive function.
*
*
* I attach the knapsack explanation that I think is most understandable in the resources folder.
* */

import java.util.Scanner;

public class KnapSack {
    static int W;// the max capacity
    static int N;// the total number of items
    static int[] v; // an array of values
    static int[] w; // an array of weight
    static PackageItem[] items;
    static int[][] sackMatrix;
    static int[][] keep;

    static class PackageItem{
        private char name;
        private int value;
        private int weight;
        public PackageItem(char n, int v, int w){
            name = n;
            value = v;
            weight = w;
        }
    }

    static {
        W = 10;
        N = 4;
        sackMatrix = new int[N+1][W+1];
        v = new int[]{10, 40, 30, 50};
        w = new int[]{5, 4, 6, 3};
        items = new PackageItem[N+1];
        for (int i=1;i<=N;i++){
            items[i] = new PackageItem((char)('a'+ i -1), v[i-1], w[i-1]);
        }
        keep = new int[N+1][W+1];
    }

    static int[] solve(){

        for (int j=0;j<=W;j++){
            sackMatrix[0][j] = 0;
        }

        for (int i=1;i<=N;i++){
            sackMatrix[i][0] = 0;
            for (int j=1;j<=W;j++){
                if (j >= items[i].weight && items[i].value + sackMatrix[i-1][j - items[i].weight] > sackMatrix[i-1][j]){
                    sackMatrix[i][j] = items[i].value + sackMatrix[i-1][j - items[i].weight];
                    keep[i][j] = 1;
                }else{
                    sackMatrix[i][j] = sackMatrix[i-1][j];
                    keep[i][j] = 0;
                }
            }
        }
        System.out.println("Maximum: " + sackMatrix[N][W]);
        // this part is going to return the solution for keeping which package
        // by traverse back
        int K = W;
        int[] result = new int[N + 1];
        for (int i=N;i>0;i--){
            if (keep[i][K] == 1){
                System.out.print(items[i].name + " -> ");
                K = K - items[i].weight;
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        solve();
    }
}
