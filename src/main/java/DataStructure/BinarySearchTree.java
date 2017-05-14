package DataStructure;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>>{

    // inner class node
    static class BinarySearchNode<T>{
        private T data;
        private BinarySearchNode<T> left;
        private BinarySearchNode<T> right;

        public void setData(T data){
            this.data = data;
        }
        public T getData(){
            return this.data;
        }
        public void setLeft(BinarySearchNode<T> l){
            this.left = l;
        }
        public BinarySearchNode<T> getLeft(){
            return this.left;
        }
        public void setRight(BinarySearchNode<T> r){
            this.right = r;
        }
        public BinarySearchNode<T> getRight(){
            return this.right;
        }

        public BinarySearchNode(T data, BinarySearchNode<T> left, BinarySearchNode<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public BinarySearchNode(T data){
            this(data, null, null);
        }

    }

    private BinarySearchNode<T> root;

    public void setRoot(BinarySearchNode<T> root){
        this.root = root;
    }
    public BinarySearchNode<T> getRoot(){
        return this.root;
    }

    // insert data to BST
    public void insert(T dataToInsert){
        // O[log(n)] which is actually the height of the BST
        BinarySearchNode<T> nodeToInsert = new BinarySearchNode<T>(dataToInsert);
        if(this.getRoot() == null){
            this.setRoot(nodeToInsert);
        }else{
            insertNode(this.root, dataToInsert);
        }
    }
    public void insertNode(BinarySearchNode<T> currentNode, T dataToInsert){
        BinarySearchNode<T> leftNode = currentNode.getLeft();
        BinarySearchNode<T> rightNode = currentNode.getRight();

        //  put dataToInsert on the left if the dataToInsert is less then currentNode
        if(currentNode.getData().compareTo(dataToInsert) > 0){
            if(currentNode.getLeft() == null){
                currentNode.setLeft(new BinarySearchNode<T>(dataToInsert));
            }else{
                insertNode(leftNode, dataToInsert);
            }
        }

        // put dataToInsert on the right if the dataToInsert is larger then currentNode
        if(currentNode.getData().compareTo(dataToInsert) < 0){
            if(currentNode.getRight() == null){
                currentNode.setRight(new BinarySearchNode<T>(dataToInsert));
            }else{
                insertNode(rightNode, dataToInsert);
            }
        }
    }

    // delete node in BinarySearchTree
    public Boolean delete(BinarySearchNode<T> root, T value){
        // time complexity is also O[log(n)]
        BinarySearchNode<T> nodeToRemove = findNode(root, value);
        // node not found
        if (nodeToRemove == null){
            return false;
        }
        BinarySearchNode<T> parentNode = findParent(value, nodeToRemove);
        // if the value to be deleted is the only node means the parent node is null
        if(parentNode == null){
            nodeToRemove = null;
            return true;
        }

        // if the value to be deleted is a leaf node
        if (nodeToRemove.getLeft() == null && nodeToRemove.getRight() == null){
            // case right node
            if (parentNode.getData().compareTo(nodeToRemove.getData()) < 0){
                parentNode.setRight(null);
            }else{
                // case left node
                parentNode.setLeft(null);
            }
            return true;
        }

        // if the value to be deleted has left subtree but no right subtree
        if (nodeToRemove.getLeft() != null && nodeToRemove.getRight() == null){
            // case right node
            if (parentNode.getData().compareTo(nodeToRemove.getData()) < 0){
                parentNode.setRight(nodeToRemove.getLeft());
            }else{
                parentNode.setLeft(nodeToRemove.getLeft());
            }
            return true;
        }

        // if the value to be deleted has right subtree but no left subtree
        if (nodeToRemove.getLeft() == null && nodeToRemove.getRight() != null){
            // case right node
            if (parentNode.getData().compareTo(nodeToRemove.getData()) < 0){
                parentNode.setRight(nodeToRemove.getRight());
            }else{
                parentNode.setLeft(nodeToRemove.getLeft());
            }
            return true;
        }

        // if the value to be deleted has both right subtree and left subtree
        if (nodeToRemove.getLeft() != null && nodeToRemove.getRight() != null){
            // find the largest value of the left subtree
            BinarySearchNode<T> largestNode = nodeToRemove.getLeft();
            while(largestNode != null){
                largestNode = largestNode.getRight();
            }
            // once found the largest value of the left subtree,
            // then delete that node and set the target node value to the largest value
            nodeToRemove.setData(largestNode.getData());
            findParent(largestNode.getData(), getRoot()).setRight(null);
            return true;
        }
        return false;
    }

    // find parent node for the given node because when deleting a node, you have to reset the parent node
    // value indicate the value of the child node, root indicate the root of the tree
    public BinarySearchNode<T> findParent(T value, BinarySearchNode<T> root){
        if(root.getData().compareTo(value) == 0){
            return null;
        }
        // root is larger, check the left
        if(root.getData().compareTo(value) > 0){
            if(root.getLeft() == null){
                return null;
            }else if(root.getLeft().getData().compareTo(value) == 0){
                return root;
            }else{
                return findParent(value, root.getLeft());
            }
        }
        // root is smaller, check the right
        if(root.getData().compareTo(value) < 0){
            if(root.getRight() == null){
                return null;
            }else if(root.getRight().getData().compareTo(value) == 0){
                return root;
            }else{
                return findParent(value, root.getRight());
            }
        }
        return null;
    }
    // find the node of the given value
    public BinarySearchNode<T> findNode(BinarySearchNode<T> root, T value){
        if(root == null){
            return null;
        }
        if(root.getData() == value){
            return root;
        }
        if(root.getData().compareTo(value) < 0){
            return findNode(root.getRight(), value);
        }
        if(root.getData().compareTo(value) > 0){
            return findNode(root.getLeft(), value);
        }
        return null;
    }


    // search node in BinarySearchTree
    public Boolean contains(BinarySearchNode<T> root, T value){
        // time complexity is the same as insert
        if(root == null){
            return false;
        }
        if(root.getData() == value){
            return true;
        }
        // root value is larger, so search for left tree
        if(root.getData().compareTo(value) > 0){
            return contains(root.getLeft(), value);
        }
        // root value is smaller, so search for right tree
        if(root.getData().compareTo(value) < 0){
            return contains(root.getRight(), value);
        }
        return false;
    }

    // traverse through the BinarySearchTree

    // left subtree and then right subtree
    // TODO: should change to queue as return type for testing
    public void preorderTraversal(BinarySearchNode<T> root){
        if (root != null){
            System.out.println(root.getData());
            preorderTraversal(root.getLeft());
            preorderTraversal(root.getRight());
        }
    }

    // first traverse and then print
    // TODO: should change to queue as return type for testing
    public void postorderTraversal(BinarySearchNode<T> root){
        if (root != null){
            postorderTraversal(root.getLeft());
            postorderTraversal(root.getRight());
            System.out.println(root.getData());
        }
    }

    // able to print by line and change to new line automatically
    // basic idea is expand the tree into a new queue
    public void breadthFirstTraversal(){
        Queue<BinarySearchNode<T>> queue = new ArrayDeque<BinarySearchNode<T>>();

        BinarySearchNode<T> root = this.getRoot();
        queue.add(root);
        // current most right node
        BinarySearchNode<T> last = root;
        // next row most right node
        BinarySearchNode<T> nextLast = root;

        while(!queue.isEmpty()){
            // help node for traversal on the current row
            BinarySearchNode<T> tempNode = queue.poll();

            if(tempNode.getLeft() != null){
                queue.add(tempNode.getLeft());
                nextLast = tempNode.getLeft();
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
                nextLast = tempNode.getRight();
            }

            if(tempNode == last){
                System.out.println(tempNode.getData());
                last = nextLast;
            }else{
                System.out.print(tempNode.getData() + " ");
            }

        }
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(23);
        tree.insert(14);
        tree.insert(31);
        tree.insert(7);
        tree.insert(17);
        tree.insert(30);
        tree.breadthFirstTraversal();
       System.out.println(tree.contains(tree.getRoot(), 9));
       System.out.println(tree.findNode(tree.getRoot(), 7));
       System.out.println(tree.findParent(31, tree.getRoot()).getData());
    }
}
