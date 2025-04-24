package DataStructure.Searching;

import org.junit.Before;
import org.junit.Test;

/*
* this implementation include search, insert and delete element on hashtable
* it is important to know that you have to use the algorithm for constructing and searching hashtable
* here we use open addressing and linear searching for construction
* */
public class HashTableImpl {
    static int MAX_SIZE = 100;
    static TableEntry[] table;
    static int p = 97; // the max prime used for be modded
    static int NULL_KEY = -1;
    static class TableEntry{
        int key;
        int value;
        int count; // used for calculating the visit frequency of this entry
        TableEntry(int k, int v, int c){
            key = k;
            value = v;
            count = c;
        }
    }

    public static int search(TableEntry[] table, int key, int prime){
        int hash_address = key % prime;

        while (table[hash_address].key != NULL_KEY && table[hash_address].key != key){
            hash_address = (hash_address + 1) % prime;
        }
        // found
        if (table[hash_address].key == key)
            return hash_address;
        else
            return -1;// default to not found
    }

    //TODO
    public static boolean insert(int data){
        return false;
    }
    public static void initialTable(TableEntry[] table){
        for (int i = 0 ;i<table.length;i++){
            table[i].key = NULL_KEY;
            table[i].count = 0;
        }
    }
    //TODO
    public static boolean delete(TableEntry[] table, int key, int prime){
        return false;
    }


    @Before
    public void setup(){
        table = new TableEntry[MAX_SIZE];

    }
    @Test
    public void testSearching(){

    }
}
