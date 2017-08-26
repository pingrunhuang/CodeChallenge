import org.junit.Test;

/**
 * Created by Frank on 26/08/2017.
 */
public class RegexTest {
    @Test
    public void testSplit(){
        String str = "john - & + $ ? . @ boy, richard. me@@ hello-tim+wow    ...... tom";

        String[] strList = str.split("[\\s@&.?$+\\-,]+");
        for (String s : strList){
            System.out.println(s);
        }

    }
}
