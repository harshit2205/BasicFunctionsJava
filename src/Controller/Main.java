package Controller;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Say say = (x)->System.out.println("Controller.Say Something");

        //for each method java..
        System.out.println("\nfor each method java.. \n");
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(1,2);
        myMap.put(2,3);
        myMap.put(3,4);
        myMap.put(4,5);
        myMap.put(5,6);
        myMap.forEach((x, value) -> {System.out.println("value for x : "+x+" is "+value);});

        //string joiner feature in java8..
        System.out.println("\nString joiner feature java 8..\n");
        StringJoiner joiner = new StringJoiner(",");
        joiner.add("lets");
        joiner.add("join");

        System.out.println(joiner.toString());

        //streams feature in java 8 ..
        System.out.println("\nstreams features in java 8..\n");
        System.out.println("\n from arrays\n");
        int[] arr = new int[10];
        for(int i = 0; i< arr.length; i++){
            arr[i] = i*10;
        }
        IntStream stream = Arrays.stream(arr);
        List<Integer> val = stream.map(x -> x+3).boxed().collect(Collectors.toList());
        val.forEach(System.out::println);
        //stream filter feature..
        System.out.println("\nstream filter feature..\n");
        IntStream stream1 = Arrays.stream(arr);
        val = stream1.boxed().filter(x -> x<70 && x>30).collect(Collectors.toList());
        val.forEach(System.out::println);
    }

}

interface Say{
    public void sayS(int x);
}

//singleton interface example..
 enum SingletonEnum {
    INSTANCE, OMEGA;


    int value=3;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}