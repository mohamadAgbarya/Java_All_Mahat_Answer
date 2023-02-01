package Mahats;

import java.text.Format;
import java.text.MessageFormat;
import java.util.Scanner;


public class Mahat_Summer_2020_A {
    public static void main(String[] args) {

//        Q1();

        int c =q3_a(12345);
        System.out.println(c);
        q3_b();

        int x=1;


        int[] arr = {22, 56, 123, 12, 10, -4, 2};

        boolean ans = q4(arr);
        System.out.println(ans);
        ans = q4_1(arr);
        System.out.println(ans);


        Scanner sc = new Scanner(System.in);
        printDriverName(new Truck[]{});
        printFreeAndBig(new Truck[]{});

    }



    private static void Q1() {
        Scanner sc = new Scanner(System.in);
        int num;
        int count = 0;
        int evenCount = 0;
        int sumPos = 0;
        int countPos = 0;

        while ((num = sc.nextInt()) != 0) {
            count++;
            if (num % 2 == 0)
                evenCount++;
            if (num > 0) {
                sumPos += num;
                countPos++;
            }
        }
        System.out.println(MessageFormat.format(
                "count number= {0}," +
                        " count even number = {1}" +
                        " avg pos number = {2}"
                , count, evenCount, ((double) (sumPos / countPos))));

    }

    private static int q3_a(int num) {
        int c = 0;
        while (num > 0) {
            c += (num % 2);
            num /= 10;
        }
        return c;

    }
    private static void q3_b() {
        int[] arr = {1245, 34781, 23, 468, 139};
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (q3_a(arr[i]) < q3_a(res)) {
                res = arr[i];
            }
        }
        System.out.println(res);
    }

    //T(n)=6n+8
    //O(n)
    public static boolean q4(int[] arr) {
        if (arr == null || arr.length < 3 || arr.length % 2 == 0)
            return false;

        int size = arr.length;
        int middle = size / 2;

        for (int i = 0; i < middle; i++)
            if (arr[i] <= arr[middle])
                return false;

        for (int i = middle + 1; i < size; i++)
            if (arr[i] >= arr[middle])
                return false;

        return true;
    }

    //T(n)=5n+7
    //O(n)
    // סיבוכיות הפתרון הינה לינארית מכיוון ואנחנו רצים על גודל המערך פעם אחת בדיוק ובריצה מבצעים השוואה יחידה של איבר האמצע מול כל איבר השונה ממנו
    private static boolean q4_1(int[] arr) {
        if (arr == null || arr.length < 3 || arr.length % 2 == 0)
            return false;
        int size = arr.length;
        int middle = size / 2;
        for (int i = 0; i < size; i++) {
            if (i != middle) {
                if (i < middle) {
                    if (arr[i] <= arr[middle])
                        return false;
                } else {
                    if (arr[i] >= arr[middle])
                        return false;
                }
            }
        }
        return true;
    }

    private static String printFreeAndBig(Truck[] trucks) {
        if (trucks == null)
            return "";

        Truck bigNumStorage = null;
        int maxNumStorage = 0;
        int i = 0;
        while (i < trucks.length) {
            if (trucks[i].isFree()) {
                bigNumStorage = trucks[i];
                maxNumStorage = trucks[i].getNumStorage();
                break;
            }
            i++;
        }
        for (int j = i; j < trucks.length; j++) {
            if (trucks[j].isFree() && trucks[j].getNumStorage() > maxNumStorage) {
                bigNumStorage = trucks[j];
                maxNumStorage = trucks[j].getNumStorage();
            }
        }

        return (bigNumStorage == null) ? "Unable to service" : bigNumStorage.getTruckId();
    }

    private static void printDriverName(Truck[] trucks) {
        Truck[] t = new Truck[]{};

        if (trucks == null)
            return;

        for (int i = 0; i < trucks.length; i++) {
//            // ------------------------------------------------------
//            if(!trucks[i].isFree() || trucks[i].getNumStorage()<7){
//                continue;
//            }
//            System.out.println(trucks[i].getDriverName());
//            // ------------------------------------------------------

            // ------------------------------------------------------
            if (trucks[i].isFree() && trucks[i].getNumStorage() >= 7) {
                System.out.println(trucks[i].getDriverName());
            }
            // ------------------------------------------------------

        }

    }


}

// ----------------------------- Q7 -----------------------------
class Truck {

    private String truckId;
    private String driverName;
    private int numStorage;
    private boolean isFree;

    public Truck(String truckId, String driverName, int numStorage) {
        this.truckId = truckId;
        this.driverName = driverName;
        this.numStorage = numStorage;
        this.isFree = true;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getNumStorage() {
        return numStorage;
    }

    public void setNumStorage(int numStorage) {
        this.numStorage = numStorage;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}