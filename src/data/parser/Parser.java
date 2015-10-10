package data.parser;

import data.DataAnalizer;
import data.TreeElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/15 19:19
 */
public abstract class Parser {

    private Map<String, Class> classMap;


    public abstract boolean canParse(int TYPEOBJ);

    public abstract Map<String, Class> initClassMap();

    public boolean canParse(List<DataAnalizer.Entry> entries) {
        for (DataAnalizer.Entry entry : entries) {
            if (entry.key.equalsIgnoreCase("TYPECMD")){
                int val = Integer.parseInt(entry.value);
                if(val != 5 && val != 3) return false;
            }
            if (entry.key.equalsIgnoreCase("TYPEOBJ")) {
                return canParse(Integer.parseInt(entry.value));
            }
        }
        return false;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public TreeElement parse(List<DataAnalizer.Entry> entries) {
        if(classMap == null) classMap = initClassMap();
        Deque<Object> stack = new LinkedList<>();
        Object res = null;
        for (DataAnalizer.Entry entry : entries) {
            try {
                String key = entry.key;
                Object val = entry.value;
                if (key.equalsIgnoreCase("BEGIN")) {

                    val = ((String) val).replaceAll("\\d", "");
                    Class<?> clazz = classMap.get(val);
                    stack.push(clazz.newInstance());
                    continue;

                } else if (key.equalsIgnoreCase("END")) {
                    val = ((String) val).replaceAll("\\d", "");
                    key = (String) val;
                    val = stack.pop();
                }
                Object object = stack.peek();

                res = mergeObject(object, val);
                if(object != null)
                    setTargetField(object, object.getClass(), key, val);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return (TreeElement) res;
    }

    private void setTargetField(Object object, Class clazz, String key, Object val) {

        if(object.getClass() == val.getClass()  ) return;
        if (clazz == Object.class) return;
        try {
            if (List.class.isAssignableFrom(object.getClass())) {
                setCollections(object, clazz, key, val);
                return;
            }
            Field field = clazz.getDeclaredField(key);
            field.setAccessible(true);
            field.set(object, val);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            if (e instanceof NoSuchFieldException) {
                setTargetField(object, clazz.getSuperclass(), key, val);
            } else e.printStackTrace();
        }
    }

    private void setCollections(Object object, Class clazz, String key, Object val) {
        if (clazz == Object.class) return;
        try {
            Method method = object.getClass().getMethod("add", Object.class);
            method.invoke(object, val);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            if (e instanceof NoSuchMethodException) {
                setTargetField(object, clazz.getSuperclass(), key, val);
            } else e.printStackTrace();
        }
    }

    public static Object mergeObject(Object hunter, Object prey) {
        if(hunter == null) return prey;
        if (hunter.getClass() != prey.getClass()) return hunter;
        Field[] hunters = hunter.getClass().getFields();
        Field[] preys = prey.getClass().getFields();
        try {
            for (int i = 0; i < hunters.length; i++) {
                Field huntersField = hunters[i];
                Field preysField = preys[i];
                if(Modifier.isStatic(huntersField.getModifiers())) continue;
                huntersField.setAccessible(true);
                preysField.setAccessible(true);
                Object obj = preysField.get(prey);
                if (obj != null) huntersField.set(hunter, obj);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return hunter;
    }

    protected void setClassMap(Map<String, Class> classMap) {
        this.classMap = classMap;
    }
}
