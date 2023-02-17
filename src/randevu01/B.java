package randevu01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class B{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()) {
            Object el = it.next();
            it.set(el + "!");
        }
        System.out.println(list);
    }
    }




