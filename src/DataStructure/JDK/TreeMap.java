
/*
A rough implementation of JAVA TreeMap inspired by https://crowhawk.github.io/2017/08/31/collection_5/
Under the hood is using the Red Black tree
*/
public class TreeMap<K,V> {
  static final class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> parent;
    Entry<K,V> left;
    Entry<K,V> right;

  }
  private Entry<K,V> root;

  public boolean put(Entry<K,V> entry){

  }

}
