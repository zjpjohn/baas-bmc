package test.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 16-3-30.
 */
public class testArrayList {

    public static void main(String[] args) {
        List<String> arrayA = new ArrayList<String>();
        List<String> arrayB = new ArrayList<String>();
        arrayA.add("A");
        arrayA.add("B");
        arrayA.add("C");
        arrayA.add("D");

        arrayB.add("A");
        arrayB.add("B");

        for (String value : arrayB){
            arrayA.remove(value);
        }

        System.out.println(arrayA.size());
    }
}
