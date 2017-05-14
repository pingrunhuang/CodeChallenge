package CodeChallenge;

import java.util.Scanner;
/*

某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大 
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

你的输出为:

19
*/


public class Restaurentdidi {
    static class Batch{
        public int people;
        public int money;
        public Batch(int p, int m){
            this.people = p;
            this.money = m;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] re = input.split("\\s+");
        int n = Integer.parseInt(re[0]);
        int m = Integer.parseInt(re[1]);
        Batch[] finalCustomer = new Batch[n];
        Batch[] batches = new Batch[m];

        input = scanner.nextLine();
        for (int i=0;i<n;i++){
            int people = Integer.parseInt(input.split(" ")[i]);
            finalCustomer[i] = new Batch(people, 0);
        }


        for (int i=0;i<m;i++){
            input = scanner.nextLine();
            int b = Integer.parseInt(input.split(" ")[0]);
            int c = Integer.parseInt(input.split(" ")[1]);
            batches[i] = new Batch(b,c);
        }

        // compute
        for (int i=0;i<m-1;i++){
            for (int j=i+1;j<m;j++){
                if (batches[i].money<batches[j].money){
                    Batch temp = batches[i];
                    batches[i] = batches[j];
                    batches[j] = temp;
                }
            }
        }

        for (int i = 0;i<m;i++){
            Batch current = batches[i];
            for(int j = 0 ;j<n;j++){
                if(current.people < finalCustomer[j].people){
                    if (current.money > finalCustomer[j].money){
                        finalCustomer[j].money = current.money;
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (int i=0;i<n;i++){
            result += finalCustomer[i].money;
        }
        System.out.println(result);
    }
}
