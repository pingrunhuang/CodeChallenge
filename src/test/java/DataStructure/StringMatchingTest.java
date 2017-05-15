package DataStructure;

import org.junit.Assert;
import org.junit.Test;

public class StringMatchingTest {
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
        Assert.assertEquals(15, KMP.kmpMatch(string1, pattern1));

    }
}
