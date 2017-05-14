package CodeChallenge.String;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestString {

    @Test
    public void testExchangeSubString(){
        String test = "ABCDE";
        int i = 2;
        String expected = "DEABC";
        Assert.assertEquals(expected, ExchangeSubString.exchange(test, i));
    }

    @Test
    public void testIsReverseStr(){
        String pattern_str = "1234";
        String target_str1 = "4123";
        String target_str2 = "4231";
        Assert.assertTrue(IsReverseStr.isReverse(pattern_str, target_str1));
        Assert.assertFalse(IsReverseStr.isReverse(pattern_str, target_str2));
    }

    @Test
    public void testReverseSentence(){
        String str = "I love dogs";
        assertEquals("dogs love I", ReverseSentence.getResult(str));
    }
}
