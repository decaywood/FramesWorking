package views;

import utils.ColleagueAdapter;
import utils.ColleagueManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: decaywood
 * @date: 2015/9/14 11:12
 */
public class ColleagueTestClass  {



    public static void main(String[] args) {
        ColleagueManager manager = ColleagueManager.Holder.MANAGER;
        manager.register("str", new StringColleague());
        manager.register("list", new ListColleague());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        String str = "i am a data";
        manager.setData("str", list).update();
        manager.setData("str", str).update();
        manager.setData("list", list).update();
        manager.setData("list", str).update();
    }

    private static class StringColleague extends ColleagueAdapter<String> {
        private String data;

        @Override
        public void setData(String data) {
            this.data = data;
            System.out.println(data);
        }

        @Override
        public void update() {
            System.out.println("update -> " + data);
        }
    }

    private static class ListColleague extends ColleagueAdapter<List<Integer>> {
        private List<Integer> data;

        @Override
        public void setData(List<Integer> data) {
            this.data = data;
            System.out.println(data);
        }

        @Override
        public void update() {
            System.out.println("update -> " + data);
        }
    }


}
