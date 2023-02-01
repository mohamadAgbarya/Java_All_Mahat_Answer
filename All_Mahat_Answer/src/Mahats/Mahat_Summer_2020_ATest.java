//package Mahats;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Random;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Mahat_Summer_2020_ATest {
//
//    @Test
//    void Test_q4() {
//        Random rd = new Random();
//        int[] arr;
//        for (int i = 3; i <1000 ; i+=2) {
//            arr=g(i);
//            assertTrue(Mahat_Summer_2020_A.q4(arr));
//        }
//        for (int i = 0; i <1000 ; i+=2) {
//            arr=g(i);
//            assertFalse(Mahat_Summer_2020_A.q4(arr));
//        }
//        for (int i = 3; i <1000 ; i+=2) {
//            arr=g(i);
//            int middle= arr.length/2;
//            int num = rd.nextInt(middle);
//            arr[num]=arr[arr.length/2]-1;
//            assertFalse(Mahat_Summer_2020_A.q4(arr));
//        }
//
//    }
//
//    private int[] g(int n) {
//        int[] arr = new int[n];
//        Random rd = new Random();
//        int middle = n / 2;
//
//        arr[middle] = rd.nextInt(21) + 100;
//        for (int i = 0; i < middle; i++) {
//            arr[i] = rd.nextInt(1000) + 121;
//        }
//
//        for (int i = middle + 1; i < n; i++) {
//            arr[i] = rd.nextInt(100);
//        }
//
//        return arr;
//    }
//}