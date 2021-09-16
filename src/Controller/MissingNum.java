package Controller;

public class MissingNum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 3, 7, 8};
        int xor = 0;
        for(int i=1; i<=arr.length+1; i++) xor ^= i;
        for (int j : arr) xor ^= j;

        System.out.println(xor);
    }

}
