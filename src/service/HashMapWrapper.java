package service;

import java.io.Serializable;
import java.util.HashMap;

public class HashMapWrapper implements Serializable {   // Since HashMap can't be returned to XML, client Wrapper is used
    private HashMap hashMap;

    public HashMapWrapper(HashMap<String, Integer> hashMap){
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        String output = "";
        for (Object key : hashMap.keySet()) {
            output += ("\"" + key + "\"" + " : " + hashMap.get(key) + "\n");
        }
        return output;
    }
}
