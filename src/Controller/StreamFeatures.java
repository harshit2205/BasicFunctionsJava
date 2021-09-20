package Controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFeatures {

    public static void main(String[] args) {
        System.out.println("\nStream Features..\n");

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        Stream<Integer> myStream = Arrays.stream(arr).boxed();
        System.out.println("\nStream for each method.. \n");
        myStream.forEach(System.out::println);

        System.out.println("\nStream map method.. \n");
        myStream = Arrays.stream(arr).boxed();
        myStream.map(x -> x * 3).forEach(System.out::println);

        System.out.println("\nStream collect with map method.. \n");
        myStream = Arrays.stream(arr).boxed();
        List<Integer> value = myStream.map(x -> x * 3).collect(Collectors.toList());
        value.forEach(System.out::println);

        System.out.println("\nStream map method.. \n");
        myStream = Arrays.stream(arr).boxed();
        Integer firstElement = myStream.findFirst().get();


        System.out.println("\nto array method of stream.. \n");
        IntStream stream = Arrays.stream(arr);

        System.out.println("\nstream peek method used for applying some operations and then returning the stream\n");
        myStream = Arrays.stream(arr).boxed();
        myStream.forEach(System.out::println);
        System.out.println("now edited\n");
        myStream = Arrays.stream(arr).boxed();
        myStream.peek(x -> x = x + 3).peek(System.out::println).collect(Collectors.toList());
        // peek method is not very relevant method to use for working on production code so rather using it on debugging process
        // is more convinient and correct..

        System.out.println("\nstream sorted method\n");
        myStream = Arrays.stream(arr).boxed();
        Integer integer = myStream.max((e1,e2) -> e1.compareTo(e2)).get();
        System.out.println(integer);
//        myStream.sorted(Comparator.reverseOrder()).peek(System.out::println).collect(Collectors.toList());


        String[] arrChar = new String[10];
        Stream<String> charStream = Arrays.stream(arrChar);
    }


}
