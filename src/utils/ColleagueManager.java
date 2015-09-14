package utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: decaywood
 * @date: 2015/9/14 10:10
 */
public class ColleagueManager {

    Map<String, Colleague> colleagues;

    private ColleagueManager() {
        this.colleagues = new HashMap<>();
    }

    public static class Holder {
        public static final ColleagueManager MANAGER = new ColleagueManager();
        private static final Colleague DUMMY_COLLEAGUE = new ColleagueAdapter<>();
    }

    public void register(String name, Colleague colleague) {
        colleagues.put(name, colleague);
    }


    /**
     * 可以使用调用链： setData(...).update();
     */
    public <T> Colleague setData(String name, T data) {
        if(!colleagues.containsKey(name)){
            System.out.println("没有此目标！请求目标 -> " + name);
            return Holder.DUMMY_COLLEAGUE;
        }
        Colleague colleague = colleagues.get(name);
        try {
            //        noinspection unchecked
            colleague.setData(data);
            return colleague;
        } catch (Exception e) {
            ParameterizedType parameterizedType = (ParameterizedType) colleague.getClass().getGenericSuperclass();
            Type type = parameterizedType.getActualTypeArguments()[0];
            System.out.println("设置类型错误！请求目标类型 -> " +data.getClass().getSimpleName() + " 需要类型 -> " + type.getTypeName());
        }
        return Holder.DUMMY_COLLEAGUE;
    }

    public void update(String name) {
        if(!colleagues.containsKey(name)){
            System.out.println("没有此目标！请求目标 -> " + name);
            return;
        }
        colleagues.get(name).update();
    }



}
