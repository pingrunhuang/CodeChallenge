package DataStructure;

public class DoubleLinkedList<T>{

  private T data;
  private DoubleLinkedList<T> pre;
  private DoubleLinkedList<T> next;

  public DoubleLinkedList(T data){
    this(data, null, null);
  }

  public DoubleLinkedList(T data, DoubleLinkedList<T> pre, DoubleLinkedList<T> next){
    this.pre = pre;
    this.data = data;
    this.next = next;
  }

  public DoubleLinkedList<T> insert(T value){
    // O(N)
    DoubleLinkedList<T> node = new DoubleLinkedList<T>(value, null, null);
    if(this.getNext() == null){
      this.setNext(node);
      node.setPre(this);
    }else{
      this.getNext().setPre(node);
      node.setNext(this.getNext());
      node.setPre(this);
      this.setNext(node);
    }
    return node;
  }

  public Boolean delete(T value){
    // O(N)
    // the target node is the head
    return false;

  }

  public void setData(T data){
    this.data = data;
  }
  public T getData(){
    return this.data;
  }

  public void setPre(DoubleLinkedList<T> pre){
    this.pre = pre;
  }
  public DoubleLinkedList<T> getPre(){
    return this.pre;
  }

  public void setNext(DoubleLinkedList<T> next){
    this.next = next;
  }
  public DoubleLinkedList<T> getNext(){
    return this.next;
  }

  @Override
  public String toString(){
    StringBuilder str = new StringBuilder();
    DoubleLinkedList<T> t = this;
    while(t != null){
      str.append(t.getData().toString() + "  ");
      t = t.getNext();
    }
    return str.toString();
  }

  public static void main(String[] args){
    DoubleLinkedList<Integer> head = new DoubleLinkedList<Integer>(1);
    head.insert(2).insert(3).insert(4);
    System.out.println(head.toString());
  }
}
