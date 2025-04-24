package DataStructure;

public class SinglyLinkedList{
  static class Node<T>{
    T data;
    Node<T> next;

    public Node(T data, Node<T> next){
      this.data = data;
      this.next = next;
    }

    public Node<T> insert(T value){
      // O(1)
      Node<T> n = new Node<T>(value, null);
      if (this.next == null) {
        this.next = n;
      }else{
        n.next = this.next;
        this.next = n;
      }
      return n;
    }

    public Node<T> search(T target){
      // O(n)
      Node<T> n = this;
      while (n != null){
        if(n.data == target){
          return n;
        }else{
          n = n.next;
        }
      }
      return null;
    }

    public Boolean delete(Node<T> head, T target){
      // O(n)
      if(this == null){
        // the list is empty
        return false;
      }
      if(head.next == null && head.data == target){
        // the node to delete is the only node
        head = null;
        return true;
      }

      if(head.next == null && head.data == target){
        // the node to delete is the head node
        head = head.next;
        return true;
      }
      // find the target
      while(head.next != null && head.next.data != target){
        head = head.next;
      }
      if(head.next.next == null){
        // the node to delete is the tail node
        head.next = null;
        return true;
      }
      if(head.next != null){
        // the node to delete is between the haed and tail
        head.next = head.next.next;
        return true;
      }
      // the node to delete does not exist
      return false;
    }

    public void print(){
      // O(n)
      Node<T> toBePrinted = this;
      while(toBePrinted != null){
        System.out.println(toBePrinted.data);
        toBePrinted = toBePrinted.next;
      }
    }

    public void printReverse(Node<T> curr){
      // O(n 2)
      if(curr.next != null){
        printReverse(curr.next);
      }
      System.out.println(curr.data);
    }
  }
  
  public static void main(String[] args){
    Node<Integer> list = new Node<Integer>(1, null);
    list.insert(2).insert(3);
    list.print();
    list.printReverse(list);
    System.out.println(list.search(2));
    if (list.delete(list, 3) == true){
      System.out.println("yes");
    }
    list.print();
  }
}
