package DataStructure;

/*
* Problem description:
* Given a Graph, get the shortest path from v to the point in the rest of the graph(any point in the graph)
* two options for this problem:
* 1. dijkstra (seperating the graph into 2 sets, first set is the points that are already counted, the other set is the points that are not yet counted)
* 2. floyd
* */
// TODO
public class ShortestRoutine {
    /*
    * @param graph - n x n matrix that contain the distance from one point to another(maximum means no path found)
    * @param start_point - the point to start
    * @return the distance from the start point to the rest point in the graph
    * */
    public static int[] dijkstra(int[][] graph,int start_point){
        int minusDistance = Integer.MAX_VALUE;
        // s is used to store the point(index) that are already counted, s[i]=1 if the shortest path from start point to i have been found
        // else s[i] = 0
        int[] s = new int[graph.length];
        int[] dist = new int[graph.length];// used to record the distance from a to b
        int[] path = new int[graph.length];// used to indicate if the shortest distance between a and b is found
        // initialization different array
        for (int i=0;i<graph.length;i++){
            if (i==start_point){
                s[i] = 1;
            }else{
                s[i] = 0;
            }
            dist[i] = graph[start_point][i];
            if (graph[start_point][i] == Integer.MAX_VALUE){
                path[i] = -1; // no shortest path found
            }else{
                path[i] = start_point; // found shortest path
            }
        }

        for (int i=1;i<graph.length;i++){
            int mark_index = -1;
            for (int j=0;j<graph.length;j++){// get all the points that are not in s while having the shortest path
                if (s[j] == 0 && dist[j] < minusDistance){
                    mark_index = j;
                    minusDistance = dist[j];
                }
            }
            s[mark_index] = 1;//push the mark_index point into the already counted array
            for (int j = 0;j<graph.length;j++){//modify the points that are still not yet counted (not in s)
                if (s[j] == 0){ //not yet counted
                    if (graph[mark_index][j] < Integer.MAX_VALUE &&
                            dist[mark_index] + graph[mark_index][j] < dist[j]){// the graph
                        dist[j] = dist[mark_index] + graph[mark_index][j];
                        path[j] = mark_index;
                    }
                }
            }
        }

        return dist;
    }
}
