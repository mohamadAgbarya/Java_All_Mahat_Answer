package Mahats;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021_A {


    public static void main(String[] args) {
        int ansInt;
        Q1();

        Box[] boxes = createBoxArray(10);
        String ans = Q2(boxes);
        System.out.println(ans);

        int[] arr = {1, 7, 3, 0, 13, 131, 44};
        boolean bool = Q4(arr);
        System.out.println(bool);

        bool = Q6("Hand..d");
        System.out.println(bool);

        Q8_a();

        bool = Q9_a("A#gjBb&6A");
        System.out.println(bool);
        ansInt = Q10_a(10);
        ansInt = Q10_b(new int[]{});
        bool = Q10_c(new int[]{});

    }

    //O(1)
    public static void Q1() {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int countEven = 0;
        int sumOdd = 0;
        while (i != 40) {
            int num = sc.nextInt();
            if (num < 0) {
                System.out.println("Invalid ");
                continue;
            }
            countEven += (num % 2 == 0) ? 1 : 0;
            sumOdd += (num % 2 != 0) ? num : 0;
            i++;
            if (num > 99 && num < 1000) {
                int sum = 0;
                while (num != 0) {
                    sum += num % 10;
                    num /= 10;
                }
                System.out.println(sum);
            }
            System.out.println(sumOdd);
            System.out.println(countEven);

        }


    }

    public static String Q2(Box[] boxArr) {
        int min = boxArr[0].getHeight() * boxArr[0].getLength() * boxArr[0].getWidth();
        String color = boxArr[0].getColor();
        Box b = boxArr[0];
        for (int i = 1; i < boxArr.length; i++) {
            int
                    sum = boxArr[i].getHeight() * boxArr[i].getLength() * boxArr[i].getWidth();
            if (sum < min) {
                b = boxArr[i];
                min = sum;
                color = boxArr[i].getColor();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(b);
        return color;
    }

    //O(n)
    // נניח כי גודל המערך מסומן ב-n
    // מכיוון ואנחנו עוברים באופן לינארי על כל איבר במערך פעם אחת אז הסיבוכיות היא כגודל הקלט.
    public static boolean Q4(int[] arr) {
        int size = arr.length;
        if (size % 2 == 0)
            return false;
        int i = 0;
        while (i < size / 2) {

//            switch (arr[i]) {
//                case 0:
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 6:
//                case 7:
//                case 8:
//                case 9:
//                    break;
//                default:
//                    return false;
            if (arr[i] > 9 || arr[i] < 0) {
                return false;

//            if(arr[i]>=0 && arr[i]<=9) {
//                continue;
//            }
//                else{
//                    return false;
//                }
            }
            i++;
        }
        if (arr[i] != 0)
            return false;
        i++;
        while (i < size) {
            if (arr[i] <= 9 && arr[i] > 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    //O(n)
    public static boolean Q6(String str) {
        if (str == null || str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.' || str.indexOf('.') == -1)
            return false;
        for (int i = str.indexOf('+'); i < str.lastIndexOf('+'); i++) {
            if (str.charAt(i) == '.' && str.charAt(i + 1) == '.') {
                return false;
            }
        }
        return true;
    }

    private static void Q8_a() {
        Driver[] d = new Driver[5];
        d[0] = new Driver("Yossi", "1234", 2000, 3);
        d[1] = new Driver("Avi", "7596", 1980, 7);
        d[2] = new Driver("Sara", "6051", 1995, 1);
        d[3] = new Driver("Dani", "4472", 1998, 2);
        d[4] = d[3];
        int m = 0, s = 0;
        int x = d[1].getTests();
        d[1].setTests(d[3].getTests() + 2);
        d[3].setTests(x);
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i].getTests());
            s = s + d[i].getTests();
            if (d[i].getYear() > 1995)
                m++;
        }
        System.out.println((double) s / d.length);
        System.out.println(m);

    }


    private static String[] Q8_b(Driver[] dArr, int num) {
        if (dArr == null)
            return null;

        String[] temp = new String[dArr.length];
        int k = 0;
        for (int i = 0; i < dArr.length; i++) {
            if (dArr[i].getTests() < num)
                temp[k++] = dArr[i].getName();

        }
        String[] temp2 = new String[k];
        for (int i = 0; i < k; i++) {
            temp2[i] = temp[i];
        }
        return temp2;
    }

    //O(?)
    public static boolean Q9_a(String str) {
        if (str == null)
            return false;
        String subStr = "";
        for (int i = 0, size = str.length(); i < size; i++) {
            char ch = str.charAt(i);
            subStr += (ch >= 'A' && ch <= 'Z') ? ch : "";
        }
        System.out.println(subStr);

        int j = subStr.length();
        for (int i = 0; i <= j; j--, i++) {
            if (subStr.charAt(i) != subStr.charAt(j))
                return false;
        }
        return subStr.length() != 0;
    }

    //O(t)
    private static int Q10_a(int number) {
        int count = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0)
                count++;
            number /= 10;

        }
        return count;
    }

    //O(n*t) t = max{Q10_a(arr[i])}
    private static int Q10_b(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int countEven = Q10_a(arr[i]);
            if (countEven > max)
                max = Q10_a(arr[i]);
        }
        return max;
    }

    //O(nt)
    private static boolean Q10_c(int[] arr) {
        int maxDeg = Q10_b(arr);

        int[] isOrderDeg = new int[maxDeg + 1];
        for (int i = 0; i < arr.length; i++) {
            isOrderDeg[Q10_a(arr[i])]++;
        }
        for (int i = 0; i < isOrderDeg.length; i++) {
            if (isOrderDeg[i] != 1)
                return false;
        }
        return true;
    }

    private static Box[] createBoxArray(int size) {
        Random rd = new Random();
        Box[] boxes = new Box[size];
        String[] colors = {"Red", "Green", "Blue"};
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new
                    Box(rd.nextInt(10) + 1, rd.nextInt(10) + 1, rd.nextInt(10) + 1, colors[rd.nextInt(3)]);
        }
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(boxes[i]);
        }
        System.out.println();
        return boxes;
    }
}

//------------------------ Q2 ------------------------------

class Box {
    private int height;
    private int width;
    private int length;
    private String color;

    public Box(int height, int width, int length, String color) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public Box(String color) {
        this.height = 10;
        this.width = 10;
        this.length = 10;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                '}';
    }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//------------------------ Q3 ------------------------------

class Tank {

    protected int capacity;
    private int amount;


    public Tank(int capacity) {
        this.capacity = (capacity > 0) ? capacity : 10;
        this.amount = 0;
    }

    //O(1)
    public boolean isPossible(int num, char op) {
        if (num < 0)
            return false;
        switch (op) {
            case '+':
                if (num + amount > capacity)
                    return false;
                amount += num;
                break;
            case '-':
                if (amount - num < 0)
                    return false;
                amount -= num;
                break;
            default:
                System.out.println("Invaild argument");
                return false;
        }
        return true;
    }

    //O(1)
    public boolean isFull() {
        return amount > 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static int fill(Tank t1, Tank t2) {

        int realAmount = t2.getCapacity() - t2.getAmount();
        return ((realAmount - t1.amount) < 0) ? realAmount : t1.amount;

    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//------------------------ Q7 ------------------------------

class Battery {

    private String manufacturer;
    private char size;
    private double volt;
    private boolean isNormal;

    public Battery(String manufacturer, char size, double volt, boolean isNormal) {
        this.manufacturer = manufacturer;
        this.size = size;
        this.volt = volt;
        this.isNormal = isNormal;
    }

    public Battery(char size, double volt) {
        this.manufacturer = "Duracell";
        this.size = size;
        this.volt = volt;
        this.isNormal = true;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getVolt() {
        return volt;
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }
}

class BatteryPack {


    private double price;
    private Battery[] batteries;

    public BatteryPack(double price, Battery[] batteries) {
        this.price = price;
        this.batteries = batteries;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Battery[] getBatteries() {
        return batteries;
    }

    public void setBatteries(Battery[] batteries) {
        this.batteries = batteries;
    }

    //O(1)
    public static void checkPrice(BatteryPack batteries, double sum) {
        if (sum < 0 || batteries == null)
            System.out.println("Invalid Argument");

        if (batteries.getPrice() - sum < 0)
            System.out.println("It is possible to purchase " + (sum - batteries.getPrice()));
        else if (batteries.getPrice() - sum > 0)

            System.out.println("It isn't possible to purchase " + (batteries.getPrice() - sum));
        else
            System.out.println("O.K.");
    }

    //O(1)
    public boolean isEnough(double v) {
        double sumVolt = 0;
        for (int i = 0; i < batteries.length; i++) {

//            if(batteries[i].isNormal()){
//                sumVolt+=batteries[i].getVolt();
//            }else{
//                sumVolt+=0;
//            }
            sumVolt += (batteries[i].isNormal()) ? batteries[i].getVolt() : 0;
        }
        return sumVolt >= v;
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class Driver {
    private String name;
    private String id;
    private int year;
    private int tests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public Driver(String name, String id, int year, int tests) {
        this.name = name;
        this.id = id;
        this.year = year;
        this.tests = tests;
    }
}