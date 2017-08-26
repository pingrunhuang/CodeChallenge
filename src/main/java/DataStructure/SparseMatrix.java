package DataStructure;

/*
* sparse matrix: 稀疏矩阵
* 非零的元素远远大于元素总数
* 用三元组表示，(x,y,data)
* TODO
* */

public class SparseMatrix {
    class TupleNode{
        int x;
        int y;
        int data;
    }
    class Matrix{
        int rows;
        int cols;
        int nums;
        TupleNode[] data;
    }

    public int[][] createMatrixFromTupleList(){

        return null;
    }

}
