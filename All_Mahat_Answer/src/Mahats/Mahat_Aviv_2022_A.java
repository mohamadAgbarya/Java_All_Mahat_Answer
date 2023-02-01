package Mahats;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2022_A {

    public static void main(String[] args) {
        int[] arr = q2(5);
        System.out.println(Arrays.toString(arr));

        int[] votes = new int[10];
        Scanner sc = new Scanner(System.in);
        int v;
        System.out.println("Enter ");
        while ((v = sc.nextInt()) != 0) {
            votes[v - 1]++;
        }
        System.out.println(Arrays.toString(votes));

        int[][] mat = {
                {1, 3, 8, 1, 2, 4, 5, 0, 0},
                {2, 0, 0, 0, 4, 7, 0, 0, 0},
                {3, 3, 8, 3, 1, 1, 0, 0, 1},
                {3, 3, 3, 1, 1, 1, 3, 1, 1},
        };
        boolean ans = q14_a(mat, 0);
        System.out.println(ans);
        ans = q14_b(mat);
        System.out.println(ans);


    }

    private static boolean q14_a(int[][] mat, int value) {

        for (int i = 0; i < mat.length - 1; i++) {
            for (int j = 0; j < mat[i].length - 1; j++) {
                if (mat[i][j] == value &&
                        mat[i][j + 1] == value &&
                        mat[i + 1][j] == value &&
                        mat[i + 1][j + 1] == value) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean q14_b(int[][] mat) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += q14_a(mat, i) ? 1 : 0;
        }
        return count >= 3;
    }

    private static int[] q2(int n) {
        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int numAhadot = rd.nextInt(8) + 2;
            int numAsarot = rd.nextInt(numAhadot - 1) + 1;
            arr[i] = numAsarot * 10 + numAhadot;
        }
        return arr;
    }


}

class SmallBrother {
    private int[] votes;
    private int numOfPart;

    public SmallBrother(int n) {
        this.votes = new int[n];
        this.numOfPart = n;
    }

    public int getNumOfPart() {
        return this.numOfPart;
    }

    public void update() {
        votes[findMin()] = -1;
        Init();
        numOfPart--;
    }

    public boolean isFinish() {
        if (numOfPart == 3) {
            for (int i = 0; i < votes.length; i++)
                if (votes[i] != -1)
                    System.out.println(i + 1);
            return true;
        }
        return false;
    }

    public void voting() {
        Scanner sc = new Scanner(System.in);
        int inputVote;
        while ((inputVote = sc.nextInt()) != 0) {
            if (votes[inputVote - 1] != -1)
                votes[inputVote - 1]++;
        }
    }

    private int findMin() {
        int min = 0;
        int index = -1;

        for (int i = 0; i < votes.length; i++) {
            if (votes[i] < min && votes[i] != -1) {
                min = votes[i];
                index = i;
            }
        }
        return index;
    }

    private void Init() {
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] != -1) votes[i] = 0;
        }
    }
}