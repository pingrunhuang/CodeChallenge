package CodeChallenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * 一个人要过一座80米的桥，每走一米需要吃一颗豆子，他最多可以装60颗豆子，问最少需要吃多少颗豆子才能走完桥？
 * @param:
 *  m:最多可装m颗豆子
 *  n:桥长
 *
 * @return:
 *  至少需要吃多少颗豆子
 *  走的距离刚好等于消耗的豆子数
 *  TODO
 */

public class EatBeans {
    public int solve(int m, int n){

        if (m>=n)
            return n;

        int last_consume = solve(m, n-m);


        return 3 * last_consume + m ;
    }

    @Test
    public void testSolve(){
        Assert.assertEquals(120, solve(60, 80));
    }
}
