package Mahats;

import java.util.Arrays;
import java.util.Random;

public class Mahat_Aviv_2021_B {

    public static void main(String[] args) {
        Random rd = new Random();
        char[] le = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String pass = "";
        for (int i = 0; i < rd.nextInt(20); i++) {
            for (int j = 0; j < rd.nextInt(13) + 2; j++) {
                if (j == 0)
                    pass += Character.toUpperCase(le[rd.nextInt(le.length)]);
                else pass += (rd.nextInt(2) == 1) ? le[rd.nextInt(le.length)] : rd.nextInt(10);

            }
            System.out.println(pass);
            System.out.println("Invaild argument - " + q4(pass));
            pass = "";
        }
        System.out.println("Invaild argument - " + q4("Barak14"));
        System.out.println("Invaild argument - " + q4("Barakk234"));
        System.out.println("Invaild argument - " + q4("aarak1234"));
        System.out.println("Invaild argument - " + q4("Barakshar"));

        Snack[] arrS = new Snack[4];
        arrS[0]=new Snack("b",3,1,1);
        arrS[1]=new Snack("b",3,1,1);
        System.out.println(arrS);
        System.out.println(arrS[0]);
        System.out.println(Arrays.toString(arrS));
    }

    static public boolean q4(String password) {
        if (password.length() < 8)
            return false;
        char ch = password.charAt(0);
        if (ch < 65 || ch > 90)
            return false;
        if (ch < 'A' || ch > 'Z')
            return false;
        if (!Character.isUpperCase(ch)) {
            return false;
        }
        int len = password.length();
        ch = password.charAt(len - 1);
        if (ch < 48 || ch > 58)
            return false;
        if (ch < '0' || ch > '9')
            return false;
        if (!Character.isDigit(ch)) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1))
                return false;
        }
        return true;
    }
}

class Snack {

    private String name;
    private int weight;
    private double cost;
    private int cal;


    public Snack(String name, int weight, double cost, int cal) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.cal = cal;
    }

    public boolean isGoodSnack() {
        return ((cal / weight) * 100) < 120;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }


    public static int goodSnacks(Snack[] arrS) {
        int countGoodSnacks = 0;

        if (arrS == null)
            return countGoodSnacks;

        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i].isGoodSnack() && arrS[i].getCost() < 10)
                countGoodSnacks++;
        }
        return countGoodSnacks;
    }
}
