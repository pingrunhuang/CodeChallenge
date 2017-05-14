package CodeChallenge;

/*
* Problem description:
* 抽奖活动有5个等级的奖，1等奖最大，5等奖最小，1等奖、2等奖、3等奖、4等奖各1个，5等奖有2个。
* 规则为：1等奖不能在前4 轮抽出，a等奖和b等奖不能依次抽出(先a等奖，后b等奖 or 先b等奖，后a等奖)，请用代码得出有多少种开奖的方式
*
* 输入:
* 输入： a b a、b代表不同的奖
* 输出:
* 不同开奖组合的个数
* 输入范例:
* 2 3
* 输出范例:
* 78
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rewarding {
   public static List<String> list = new ArrayList<String>();
   public static String a;
   public static String b;

   public static void match(String str, String nstr) {

   }


   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       a = s.next();
       b = s.next();
       match("", "123455");
       System.out.println(list.size());
   }
}
