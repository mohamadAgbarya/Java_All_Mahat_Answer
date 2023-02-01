package Mahats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mahat_Summer_2021_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        boolean ansBool;
        int ansInt;
        switch ((num=sc.nextInt())){
            case 1:
                //----------------------- Q1 --------------------------
                ansInt = q1();
                System.out.println(ansInt);
                break;
            case 2:
                break;
            case 3:
                //----------------------- Q3 --------------------------
                q3("Java is a good language", 'a');
                break;
            case 4:
                //----------------------- Q4 --------------------------
                int[] arr = new int[8];
                ansBool = q4_a(arr);
                System.out.println(ansBool);
                ansInt = q4_b(arr);
                System.out.println(ansInt);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                //----------------------- Q9 --------------------------
                boolean ans = q9_a(new int[]{23,24,25,26,27,28,29,31,31});
                System.out.println(ans);
                ans = q9_b(new int[]{23,24,25,26,27,28,29,30,31});
                System.out.println(ans);
                break;

        }

    }

    private static int q1() {
        Scanner sc = new Scanner(System.in);
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt3 = 0;
        String str;
        //------------------- 1 -------------------
        do {
            str = sc.nextLine();
            if (str.length() >= 4 && !str.contains("T"))
                cnt0++;
        } while (str.length() >= 4);
        System.out.println(cnt0);
        //------------------------------------------

        //------------------- 2 -------------------
        do {
            str = sc.nextLine();
            if (str.length() >= 4)
                cnt1++;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'T') {
                    cnt1--;
                    break;
                }
            }
        } while (str.length() >= 4);
        //-----------------------------------------

        //------------------- 3 -------------------

        ArrayList<String> al = new ArrayList<>();
        do {
            str = sc.nextLine();
            if (str.length() < 4)
                break;
            al.add(str);
        } while (true);
        int cnt2 = 0;
        for (int i = 0; i < al.size(); i++) {
            cnt2 += (al.get(i).contains("T")) ? 0 : 1;

            if (al.get(i).contains("T"))
                cnt2 += 0;
            else
                cnt2 += 1;

            if (!al.get(i).contains("T"))
                cnt2++;
        }
        //-----------------------------------------

        //------------------- 4 -------------------
        while ((str = sc.nextLine()).length() >= 4) {
            if (!str.contains("T"))
                cnt3++;
        }
        System.out.println(cnt3);
        //-----------------------------------------

        return cnt0;
    }

    private static void q3(String str, char ch) {
        //------------------- 1 -------------------
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                System.out.println(str.substring(i));
        }
        //-----------------------------------------
        //------------------- 2 -------------------
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                for (int j = i; j < str.length(); j++) {
                    System.out.print(str.charAt(j));
                }
                System.out.println();
            }
        }
        //-----------------------------------------


    }

    private static boolean q4_a(int[] arr) {
        //[1,9,2,8,4,7,7,4,12]
        for (int i = 2; i < arr.length; i += 2) {
            if (arr[i] <= arr[i - 2])
                return false;
        }
        //[1,9,2,8,4,7,7,4,12]
        for (int i = 1; i < arr.length - 2; i += 2) {
            if (arr[i] <= arr[i + 2])
                return false;
        }
        return true;
    }

    private static int q4_b(int[] arr) {
        int size = arr.length;
        //[1,9,2,8,3,7]
        //[1,9,2,8,3]
        if (size % 2 == 0) {
            return (arr[size - 1] < arr[0]) ? arr[size - 1] : arr[0];

        } else {
            return (arr[size - 1] < arr[0]) ? arr[size - 2] : arr[0];
        }

    }

    private static boolean q9_a(int[] arr) {
        if (arr == null)
            return false;
        if (arr.length == 0)
            return true;
        int min = arr[0];
        int max = arr[0];
        //O(n)
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        if (Math.abs(max - min) != arr.length - 1)
            return false;

        //O(n)
        int sumArray = Arrays.stream(arr).sum();
        int sum = 0;

        //O(n)
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum==sumArray;
    }

    private static boolean q9_b(int[] arr) {


        return true;
    }
}

class Necklace {
    private int redBeads;
    private int yellowBeads;
    private int greenBeads;

    public int getSize() {
        return redBeads + yellowBeads + greenBeads;
    }

    public Necklace(int redBeads, int yellowBeads, int greenBeads) {
        this.redBeads = redBeads;
        this.yellowBeads = yellowBeads;
        this.greenBeads = greenBeads;
    }

    public int getChainType() {
        if (redBeads > 0 && yellowBeads == 0 && greenBeads == 0
                || yellowBeads > 0 && redBeads == 0 && greenBeads == 0
                || greenBeads > 0 && yellowBeads == 0 && redBeads == 0) {
            return 1;
        } else if (redBeads == yellowBeads && yellowBeads == greenBeads && redBeads > 0) {
            return 2;
        } else if (redBeads > 0 && yellowBeads > 0 && greenBeads == 0
                || redBeads > 0 && greenBeads > 0 && yellowBeads == 0
                || greenBeads > 0 && yellowBeads > 0 && redBeads == 0) {
            return 3;
        } else {
            return 4;
        }
    }

    public static int getNumBoringChains(Necklace[] necklaces, int num) {
        int count = 0;
        for (Necklace necklace : necklaces) {
            if (necklace.getSize() > num && necklace.getChainType() == 3)
                count++;
        }
        return count;
    }

    public int getRedBeads() {
        return redBeads;
    }

    public void setRedBeads(int redBeads) {
        this.redBeads = redBeads;
    }

    public int getYellowBeads() {
        return yellowBeads;
    }

    public void setYellowBeads(int yellowBeads) {
        this.yellowBeads = yellowBeads;
    }

    public int getGreenBeads() {
        return greenBeads;
    }

    public void setGreenBeads(int greenBeads) {
        this.greenBeads = greenBeads;
    }
}