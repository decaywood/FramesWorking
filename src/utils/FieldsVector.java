package utils;

import data.TreeElement;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author: decaywood
 * @date: 2015/9/20 14:48
 */
public class FieldsVector<T> extends Vector<T> {

    public Map<String, String> fieldsMap;
    public TreeElement element;
    public Vector<String> columnName; 

    public FieldsVector() {
        this.fieldsMap = new HashMap<>();
    }

    public void put(String fieldName, String fieldVal) {
        fieldsMap.put(fieldName, fieldVal);
    }

    public String get(String key) {

        return fieldsMap.get(key);

    }
}
