package DataStructure;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortestRoutineTest {

    private static Logger logger = LoggerFactory.getLogger(ShortestRoutineTest.class);
    private static int INFINIT = Integer.MAX_VALUE;

    @Test
    public void dijkstraTest(){
//        int[] graph1 = {0,1,2,3,4,5,6};
        int[][] graph1 = {{0,4,6,6,INFINIT,INFINIT,INFINIT},
                {INFINIT,0,1,INFINIT,4,INFINIT,INFINIT,INFINIT},
                {INFINIT,INFINIT,0,INFINIT,6,4,INFINIT},
                {INFINIT,INFINIT,2,5,INFINIT,INFINIT},
                {INFINIT,INFINIT,INFINIT,INFINIT,0,INFINIT,6},
                {INFINIT,INFINIT,INFINIT,INFINIT,1,0,8},
                {INFINIT,INFINIT,INFINIT,INFINIT,INFINIT,INFINIT,0}
        };
        int start_point1 = 0;
        int[] expeted = {0,4,5,6,10,9,16};
        Assert.assertArrayEquals(expeted, ShortestRoutine.dijkstra(graph1,start_point1));
    }
}
