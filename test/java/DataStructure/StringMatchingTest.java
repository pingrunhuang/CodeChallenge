package DataStructure;


import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Timer;

public class StringMatchingTest {
    private Logger logger = LoggerFactory.getLogger(StringMatchingTest.class);
    @Test
    public void testGetPartialTable(){
        String patternStr1 = "ABCDABD";
        int[] expected1 = {-1,0,0,0,0,1,2};
        String patternStr2 = "abcac";
        int[] expected2 = {-1,0,0,0,1};
        int[] actual = KMP.getPartialMatchTable(patternStr1);
        Assert.assertArrayEquals(expected1, actual);
        actual = KMP.getPartialMatchTable(patternStr2);
        Assert.assertArrayEquals(expected2, actual);
    }
    @Test
    public void testFindMatching(){

        String string1 = "BBC ABCDAB ABCDABCDABDE";
        String pattern1 = "ABCDABD";
        long startTime = System.currentTimeMillis();
        Assert.assertEquals(15, KMP.kmpMatch(string1, pattern1));
        logger.info("KMP time consumption: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        Assert.assertEquals(15, StringMatching.BFMatching(string1, pattern1));
        logger.info("Brute force time consumption: " + (System.currentTimeMillis() - startTime));

        String string2 = "ababcabcacbab";
        String pattern2 = "abcac";
        startTime = System.currentTimeMillis();
        Assert.assertEquals(5,KMP.kmpMatch(string2,pattern2));
        logger.info("KMP time consumption: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        Assert.assertEquals(5, StringMatching.BFMatching(string2, pattern2));
        logger.info("Brute force time consumption: " + (System.currentTimeMillis() - startTime));

        String string3 = "abcacdabcabdabcabdabdabc";
        String pattern3 = "abcabdabc";
        startTime = System.currentTimeMillis();
        Assert.assertEquals(6, KMP.kmpMatch(string3,pattern3));
        logger.info("KMP time consumption: " + (System.currentTimeMillis() - startTime) + " ms");


        startTime = System.currentTimeMillis();
        Assert.assertEquals(6, StringMatching.BFMatching(string3, pattern3));
        logger.info("Brute force time consumption: " + (System.currentTimeMillis() - startTime));

    }
}
