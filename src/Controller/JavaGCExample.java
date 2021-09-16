package Controller;

import java.util.ArrayList;
import java.util.List;

public class JavaGCExample {
    public static void main(String[] args) {
//        Integer[] myArray = new Integer[1000 * 1000 * 1000];
        List<Pantheon> arrayList = new ArrayList<>();
        for(int i =0; ; i++){
            Pantheon p = new Pantheon();
            arrayList.add(p);
        }
    }
}

class Pantheon{
    public void doNothing(){
        // do nothing..
        System.out.println("Hello world");
    }
}
