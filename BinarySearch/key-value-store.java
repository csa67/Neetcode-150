package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key with the value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */

 /*
  * Given, key is unique and each key can have multiple values at different timestamps.
  key - (timestamp,value).
  get operation asking for the recently set timestamp which is lessor equal to the current timestamp.
  */
class TimeMap{

    Map<String,List<TimestampValuePair>> keyValStore;

    TimeMap(){
        keyValStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!keyValStore.containsKey(key)){
            keyValStore.put(key,new ArrayList<>());
        }
        keyValStore.get(key).add(new TimestampValuePair(timestamp, value));
    }

    //Search for the latest timestamp that is less than the requested timestamp.
    public String get(String key, int timestamp){
        if(!keyValStore.containsKey(key)) return "";
        List<TimestampValuePair> timeStampsList = keyValStore.get(key);
        
        return getNearesttimestamp(timeStampsList,timestamp);
    }

    private String getNearesttimestamp(List<TimestampValuePair> list, int timestamp){
        int l=0;
        int h=list.size()-1;
        String res = "";

        while(l<=h){
            int mid=(l+h)/2;
            TimestampValuePair current = list.get(mid);
            if(current.timestamp <= timestamp){
                res = current.val;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }

        return res;
    }
}

class TimestampValuePair{
    int timestamp;
    String val;

    TimestampValuePair(int timestamp,String val){
        this.timestamp = timestamp;
        this.val = val;
    }
}
/*
 * set():

Time: O(1)

Space: O(n) — for storing key → list of (timestamp, value)

get():

Time: O(log m) — where m is number of values for that key

Space: O(1)
 */

 //Approach2: Using a treemap to keep timestamps sorted and directly get the floor value.

 class TimeMap2{

    Map<String,TreeMap<Integer, String>> keyValStore;

    TimeMap2(){
        keyValStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        if(!keyValStore.containsKey(key)){
            keyValStore.put(key,new TreeMap<>());
        }
        keyValStore.get(key).put(timestamp, value);
    }

    //Search for the latest timestamp that is less than the requested timestamp.
    public String get(String key, int timestamp){
        if(!keyValStore.containsKey(key)) return "";

        TreeMap<Integer,String> timeStampMap = keyValStore.get(key);
        Integer floorTimestamp = timeStampMap.floorKey(timestamp);
        return floorTimestamp == null ? "" : timeStampMap.get(floorTimestamp);
    }
}
//set - O(logm) get - O(logm) space - O(n)




