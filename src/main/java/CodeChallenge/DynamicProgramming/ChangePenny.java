package CodeChallenge.DynamicProgramming;

/*
* 给定一个数组arr，数组中每个元素代表零钱的面额并且不重复，再给定一个aim是希望找的总额
* 求有多少中找法。
* solution 1:
*   brutal force
*
*
* */

public class Change {

    private static int[] arr = {1,5,10,20};

    /*
    * 暴力搜索产生的重复举例：
    * aim为1000，使用了1张5元和0张1元 跟 使用了0张5元和5张1元后续的递归结果是一样的，都是用n张20元和m张10元的组合去换990元
    * @param    array是零钱面额的集合
    * @param    index是当前暴力搜索的指针
    * @param    aim是目标金额
    * */
    public static int brutalForce(int[] array, int index, int aim){
        // brutal force的方法是进行递归，因为会出现重复，因此叫暴力搜索
        // 参数判断
        if (array == null || array.length == 0 || aim < 0)
            return 0;

        int result = 0;
        // 终止条件
        if (index == array.length)
            // 判断最后一位最后一位是否能满足总数为aim，可以则计数加1
            result = aim == 0 ? 1 : 0;
        else{
            for (int i=0;i*array[index]<=aim;i++){
                // 递归
                result += brutalForce(array,index++,aim-array[index]*i);
            }
        }
        return result;
    }

    /*
    * Optimization:
    * 记忆搜索法：产生暴力搜索的根本原因是有重复
    *           因此我们需要记录下每次搜索的结果，对后续的搜索进行与之前的比较
    * 本质上动态规划的优化就是一个用空间换时间的解决方案。
    * 在本题中，由于有两个变量index和aim是在递归过程中一直在改变的，因此申请一个二维的表，对组合数进行记录
    * dp[i][j] （i<array.length, j<=aim）表示只用array[0...i]这些货币进行组合得到总额为j的组合数
    * dp[i][j] = d[i-1][j-0*arr[i]] + d[i-1][j-1*arr[i]] + d[i-1][j-2*arr[i]] ... 
    * */

    public static int optimization(int index, int aim){
        int[][] dp = new int[arr.length][aim+1];

    }




}
