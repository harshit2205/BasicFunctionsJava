package Controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KthLargest {
    public static void main(String[] args) {
        int stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
        IntStream mystr = Arrays.stream(stream);
        List<Integer> value = mystr.boxed().collect(Collectors.toList());
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1,x2)-> { if(x1>x2) return -1; else return 1;});
        queue.addAll(value);
        int k =2;
        for(int i=1;i<=k;i++){
            if(i==k) System.out.println(queue.poll());
            else queue.poll();
        }
    }
}
