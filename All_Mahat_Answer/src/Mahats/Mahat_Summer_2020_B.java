package Mahats;

public class Mahat_Summer_2020_B {

    public static void main(String[] args) {
        int[] arr = {22, 56, 10, 13, 31, 44};
        boolean ans = q4(arr);
        ans = q4(null);
    }
    //T(n)=3+3+n+n+1 = 2n+7
    //O(n)
    private static boolean q4(int[] arr) {
        if (arr == null || arr.length < 4 || arr.length % 2 != 0)
            return false;

        int sum1 = 0;
        int sum2 = 0;
        int size = arr.length;

        for (int i = 0; i < size / 2; i++) {
            sum1 += arr[i];
        }
        for (int i = size / 2; i < size; i++) {
            sum2 += arr[i];
        }
        return sum1 == sum2;

    }
}
