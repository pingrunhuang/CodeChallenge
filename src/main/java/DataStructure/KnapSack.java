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
* */

import java.util.Scanner;

public class KnapSack {
    static int W;
    static int N;
    static int[] v;
    static int[] w;
    static PackageItem[] items;
    static int[][] sackMatrix;

    static class PackageItem{
        private char name;
        private int value;
        private int weight;
        public PackageItem(char n, int v, int w){
            name = n;
            weight = v;
            weight = w;
        }
    }
    static {
        W = 10;
        N = 5;
        sackMatrix = new int[N][W];
        v = new int[]{2, 2, 6, 5, 4};
        w = new int[]{6,3,5,4,6};
        for (int i=0;i<N;i++){
            items[i] = new PackageItem((char)('a'+i), v[i], w[i]);
        }
    }

    static void initializeSackMatrix(int row, int col){
        if (row == 0){
            for (int j=0;j<col;j++){
                if (j < items[row].weight){
                    sackMatrix[row][j] = 0;
                }else{
                    sackMatrix[row][j] = items[row].weight;
                }
            }
        }

        for (int j=0;j<W;j++){
            if (j - items[row].weight > 0){
//                sackMatrix[row][j] = sackMatrix[row-1][j-items[row]]
            }

        }



    }

    static int f(int i_item, int total_weight){



        return f(i_item - 2, total_weight - w[i_item - 1]) > f(i_item - 1, total_weight) ?
                f(i_item - 2, total_weight - w[i_item - 1]) : f(i_item - 1, total_weight);
    }

    public static void main(String[] args){
//        if (args.length != 2){
//            System.out.println("The input of this application should contain the W and N");
//            System.exit(-1);
//        }
//        W = Integer.parseInt(args[0]);
//        N = Integer.parseInt(args[1]);




//        v = new int[N];
//        w = new int[N];

//        Scanner input = new Scanner(System.in);
//        System.out.println("Please enter N value for each item:");
//        for (int i = 0 ;i<N; i++){
//            v[i] = input.nextInt();
//        }
//        System.out.println("Please enter N weight for each item:");
//        for (int i=0;i<N;i++){
//            w[i] = input.nextInt();
//        }

        System.out.println(f(N, W));

    }

}
