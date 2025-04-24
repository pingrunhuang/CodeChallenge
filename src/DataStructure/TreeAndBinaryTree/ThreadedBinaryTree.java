package DataStructure.TreeAndBinaryTree;

/*
* Different traversal method will return different TBT
* There are pre-order traversal, post order traversal and mid-order traversal
* */

import org.junit.Test;

public class ThreadedBinaryTree {

    class TBTNode{
        int data;
        TBTNode lChild;
        TBTNode rChild;
        int ltag;// 1 if point to the parent, 0 point to the left child
        int rtag;// 1 if point to the parent, 0 point to the right child
        public TBTNode(int value, TBTNode l, TBTNode r, int lt, int rt){
            this.data = value;
            this.lChild = l;
            this.rChild = r;
            this.ltag = lt;
            this.rtag = rt;
        }
    }

    //global variable to keep track of the previous visited node
    static TBTNode pre_node;
    /*
    * implement in mid-order
    * the basic principle is to traversal the whole binary tree
    * */
    void inOrder_thread(TBTNode current_node){

        if (current_node != null){
            // thread the left child tree
            inOrder_thread(current_node.lChild);
            if (current_node.lChild == null){
                current_node.lChild = pre_node;
                current_node.ltag = 1;
            }else
                current_node.ltag = 0;
            if (current_node.rChild == null){
                current_node.rChild = pre_node;
                current_node.rtag = 1;
            }else
                current_node.rtag = 0;
            pre_node = current_node;
            // thread the right child tree
            inOrder_thread(current_node.rChild);
        }

    }

    // this is going to add a new root node to point to the given tree
    public TBTNode construct_TBT_inOrder(TBTNode tree_root){
        TBTNode bias_root = new TBTNode(0, null, tree_root, 0, 1);
        if (tree_root == null){
            // the bias root's left child point to itself
            bias_root.lChild = bias_root;
        }else{
            // the bias root's left child point to the root of the tree
            bias_root.lChild = tree_root;
            pre_node = bias_root;
            inOrder_thread(tree_root);

            // final process: the pre_node will point to the last node, therefore we can leverage the info of pre_node
            pre_node.rChild = bias_root;
            pre_node.rtag = 1;
            bias_root.rChild = pre_node;
        }
        return bias_root;
    }

    public void traversal_thread_inOrder(TBTNode root){
        // the true root node of the tree
        TBTNode current_node = root.lChild;
        while (current_node != root){
            // find the start point
            while (current_node.ltag == 0)
                current_node = current_node.lChild;
            System.out.print(current_node.data + " ");
            while (current_node.rtag == 1 && current_node.rChild != root){
                current_node = current_node.rChild;
                System.out.println(current_node.data + " ");
            }
            current_node = current_node.rChild;
        }
    }

    // TODO: implement pre-order
    void pre_thread(TBTNode tbtNode){

    }
    // TODO: implement post-order
    void post_thread(TBTNode tbtNode){

    }


    // TODO: find the test case for TBT
    @Test
    public void testMidThread(){

    }
}
