package DataStructure.Searching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * One of the implementation of balance binary tree
 * Definition: For each node, if the height of the left child and the right child varied no more then 1, then the tree is called balanced
 * Bf(balance factor) is a measurement of the definition.
 * Bf = abs(height(left child) - height(right child)) <= 1
 * Time complexity: O(log2(n))
 * */
public class AVL {
    class BSTNode{
        int bf;
        // this field could be any other data type
        int data;
        BSTNode lchild;
        BSTNode rchild;
        BSTNode(int bf, int data, BSTNode left, BSTNode right){
            this.bf = bf;
            this.data = data;
            this.lchild = left;
            this.rchild = right;
        }
    }
    BSTNode HEAD;

    public void insert(int value){
        BSTNode new_node = new BSTNode(0, value, null, null);

        if (HEAD == null){
            HEAD = new_node;
            return;
        }


        BSTNode cur_node = HEAD;
        while (cur_node != null){
            if (value < cur_node.data){
                cur_node = cur_node.lchild;
            } else if(value > cur_node.data){
                cur_node = cur_node.rchild;
            }
        }
    }

    /**
     * the given node to be rotated is the node with bf value larger then 1
     * */
    public void R_Rotate(BSTNode node){
        // LL adjust
        BSTNode lchild_of_node = node.lchild;
        BSTNode rchild_of_child = lchild_of_node.rchild;

        lchild_of_node.rchild = node;
        node.lchild = rchild_of_child;
        recalculate_bf(node);
    }

    public void L_Rotate(BSTNode node){
        // RR adjust
        BSTNode rchild_of_node = node.rchild;
        BSTNode lchild_of_node = rchild_of_node.lchild;

        rchild_of_node.lchild = node;
        node.rchild = lchild_of_node;
        recalculate_bf(node);
    }

    public void LRInsert(BSTNode node){

    }

    public void RLInsert(BSTNode node){

    }

    private void recalculate_bf(BSTNode node){
        int left_height = get_height(node.lchild);
        int right_height = get_height(node.rchild);

        node.bf = left_height - right_height;
    }

    private int get_height(BSTNode node){
        if (node == null)
            return 0;
        // the leaf
        if (node.lchild==null && node.rchild==null)
            return 0;

        return get_height(node.lchild) > get_height(node.rchild) ? get_height(node.lchild) + 1 : get_height(node.rchild) + 1;
    }

    public void create_AVL(int[] data){
        for (int value : data){
            this.insert(value);
        }
    }


    @Before
    public void setup(){
        int[] input = {16, 3, 7, 11, 9, 26, 18, 14, 15};

        for (int value : input){

        }

    }


    @Test
    public void testInsertNode(){




    }

    @Test
    public void testGetHeight(){
        BSTNode node = new BSTNode(1, 1,null, null);
        Assert.assertEquals(0, get_height(node));
        BSTNode node1 = new BSTNode(1,1,null, node);
        BSTNode head = new BSTNode(1, 1, node1, null);
        Assert.assertEquals(2,get_height(head));
    }

    @Test
    public void testBF(){

    }
}
