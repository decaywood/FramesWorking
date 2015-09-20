package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @author: decaywood
 * @date: 2015/9/20 14:48
 */
public class FieldsVector<T> extends Vector<T> {

    public Map<String, String> fieldsMap;


    public FieldsVector() {
        this.fieldsMap = new HashMap<>();
    }

    public void put(String fieldName, String fieldVal) {
        fieldsMap.put(fieldName, fieldVal);
    }

}
