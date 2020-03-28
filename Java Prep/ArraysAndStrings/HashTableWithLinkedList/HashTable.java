import java.util.ArrayList;
import java.util.List;



/**
 * Hash Table with array linked list
 */

public class HashTable {

    String key;
    int value;

    public HashTable(String key[], int value[]){

    }
    
    public HashTable(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public  void addentries(HashTable entry, List<ArrayList<HashTable>> table) {
        int position = getHashCode(entry.key);
        System.out.println(position);
        try {
            ArrayList<HashTable> entryExist = table.get(position);
            entryExist.add(entry);
            System.out.println("addition of the entry is successful!!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("addition of the entry is successful!!");
            ArrayList<HashTable> newEntry = new ArrayList<>();
            newEntry.add(entry);
            table.add(position, newEntry);
            System.out.println("addition of the entry is successful!!");

        }
    }

    public  int getHashCode(String key) {

        return key.hashCode()%20;
    }

    public  void getEntryValue(String key, List<ArrayList<HashTable>> table) {
        int position = getHashCode(key);
        boolean entyFound = false;
        int entryValue =0;
        try {
            ArrayList<HashTable> entries = table.get(position);
           for(HashTable entry: entries){
               if(entry.key == key){
                   entyFound = true;
                   entryValue = entry.value;
               }
           }
           if(entyFound){
               System.out.println("the value of "+key+" is "+entryValue);
           } else {
               System.out.println("the entry "+key+" is not registered!!");
           }

        }catch(IndexOutOfBoundsException e) {
            System.out.println("entry does not exist!!!");
        }
    }

    public static void main(String[] args) {

        List<ArrayList<HashTable>> table = new ArrayList<ArrayList<HashTable>>(20);
        for (int i = 0; i < 20; i++) {
            table.add(i, new ArrayList<>());
        }
        //initialize the table with empty objects?     
        HashTable entry1 = new HashTable("a", 21);
        HashTable entry2 = new HashTable("bb", 11);
        HashTable entry3 = new HashTable("aaa", 100);
        HashTable entry4 = new HashTable("abc", 90);
        HashTable entry5 = new HashTable("bdb", 31);
        HashTable entry6 = new HashTable("demon",321);
        HashTable entry7 = new HashTable("demonize",321);




        entry1.addentries(entry1, table);
        // entry2.addentries(entry2, table);
        // entry3.addentries(entry3, table);
        // entry4.addentries(entry4, table);
        // entry4.addentries(entry5, table);
        // entry4.addentries(entry6, table);
        entry7.addentries(entry7, table);


        entry1.getEntryValue("abc", table);
        entry2.getEntryValue("demonize", table);
        

        /*TODO: need to find the initialization function  */
    }
}