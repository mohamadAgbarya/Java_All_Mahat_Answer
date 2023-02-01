package Mahats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Mahat_Aviv_2022_B {

    public static void main(String[] args) {
        Actor ac1 = new Actor("Max", 25, 8);
        Actor ac2 = new Actor("Bob", 48, 11);
        Actor ac3 = new Actor("Alice", 45, 9);
        Actor ac4 = new Actor("Gal", 24, 4);
        Actor ac5 = new Actor("Aviel", 85, 5);
        Actor ac6 = new Actor("Salatz", 19, 20);
        Actor ac7 = new Actor("Barak", 32, 6);

        Act act = new Act("Java", 5);

        System.out.println(act.getCurrentNum());
        //currentNum=0 init

        String ans = act.addActor(ac1);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=0 ac1 age = 25

        ans = act.addActor(ac2);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=1

        ans = act.addActor(ac3);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=2


        ans = act.addActor(ac4);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=2 ac4 age = 24

        ans = act.addActor(ac5);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=3

        ans = act.addActor(ac6);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());
        //currentNum=3 ac6 age = 16

        for (int i = 0; i < 17; i++) {
            ans = act.addActor(ac5);
            System.out.println(ans);
            System.out.println(act.getCurrentNum());
        }

        ans = act.addActor(ac5);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());

        ans = act.addActor(ac5);
        System.out.println(ans);
        System.out.println(act.getCurrentNum());

        System.out.println(act.f());

        Random rd = new Random();

        Book[] books = new Book[10];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(rd.nextInt(1564564), "book" + i, "ge" + rd.nextInt(2), rd.nextInt(10) + 1, new int[]{rd.nextInt(10), rd.nextInt(10), rd.nextInt(10), rd.nextInt(10), rd.nextInt(10)});
        }
        Library library = new Library(books);
        library.getBookByGenreRating("ge0", 2);


        MonthFuel monthFuel = new MonthFuel();
        for (int i = 0; i < 10; i++) {
            monthFuel.addInvoice(rd.nextInt(31) + 1, rd.nextInt(4) + 12345678 + "", "" + i, rd.nextInt(60) + 1 + Math.random());
        }
        System.out.println(monthFuel);
        System.out.println(monthFuel.MaxFuelPerCar());


    }

    public static Status WorldStatus(Country[] arr) {
        if (arr == null)
            return new Status();
        Status status = new Status();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getInfected() == 0)
                status.setCount1(status.getCount1() + 1);
            if (arr[i].getRecovered() > arr[i].getDead())
                status.setCount2(status.getCount2() + 1);
            if ((arr[i].getInfected() / 2) < arr[i].getRecovered())
                status.setNames(status.getNames() + ", " + arr[i].getName());
        }
        return status;
    }

    public static void f(SportUnion[] sportUnions) {
        if (sportUnions == null) {
            System.out.println("Error");
            return;
        }

        int count = 0;
        for (int i = 0; i < sportUnions.length; i++) {
            SportUnion sportUnion = sportUnions[i];

            for (int j = 0; j < sportUnion.getNumberUnion(); j++) {
                SportClube sportClube = sportUnion.getUnionData()[j];
                if (sportClube.getCountOfPlayer() >= 50)
                    count++;
            }
            if (count >= 5)
                System.out.println(sportUnion.getUnionName());
            count = 0;
        }
    }
}

class Act {
    private String actName;
    private int len;
    private Actor[] actArr;
    private int currentNum;

    public Act(String actNme, int len) {
        this.actName = actNme;
        this.len = len;
        this.currentNum = 0;
        this.actArr = new Actor[20];
    }

    public String addActor(Actor ac) {
        if (currentNum == actArr.length)
            return "no room";
        if (ac == null)
            return "Invaild argumemt";
        if (ac.getAge() < 45 || ac.getNumActs() < 5)
            return "not suitable";
        for (int i = 0; i < currentNum; i++) {
            if (actArr[i] == ac)
                return "Invaild";
        }
        actArr[currentNum] = ac;
        currentNum++;

        return "was added";

    }

    public int f() {
        int num = 0;
        for (int i = 0; i < currentNum; i++) {
            if (actArr[i].getNumActs() >= 10)
                num++;
        }
        return num;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public Actor[] getActArr() {
        return actArr;
    }

    public void setActArr(Actor[] actArr) {
        this.actArr = actArr;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }
}

class Actor {
    private String name;
    private int age;
    private int numActs;

    public Actor(String name, int age, int numActs) {
        this.name = name;
        this.age = age;
        this.numActs = numActs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumActs() {
        return numActs;
    }

    public void setNumActs(int numActs) {
        this.numActs = numActs;
    }
}

class Book {
    static int MIN_RATE = 0;
    static int MAX_RATE = 4;
    private int code;
    private String name;
    private String genre;
    private int numOfCopies;
    private int ratings[];

    public Book() {

    }

    public Book(int code, String name, String genre, int numOfCopies, int[] ratings) {
        this.code = code;
        this.name = name;
        this.genre = genre;
        this.numOfCopies = numOfCopies;
        this.ratings = ratings;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public int[] getRatings() {
        return ratings;
    }

    public void setRatings(int[] ratings) {
        this.ratings = ratings;
    }

    public void UpdateRating(int rate) {
        if (rate < MIN_RATE || rate > MAX_RATE) {
            System.out.println("Invalid Argument");
            return;
        }
        ratings[rate]++;
    }

    public double CalcRating() {

        int countRate = 0;
        int sumRate = 0;

        for (int i = 0; i < ratings.length; i++) {
            countRate += ratings[i];
            sumRate += ratings[i] * i;
        }

        return (double) sumRate / countRate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", numOfCopies=" + numOfCopies +
                ", ratings=" + Arrays.toString(ratings) +
                '}';
    }
}

class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public boolean IsAvailable(int code) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book != null) {
                int num = book.getNumOfCopies();
                if (book.getCode() == code && num != 0) {
                    book.setNumOfCopies(num - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean IsAvailable2(int code) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book != null) {
                int num = book.getNumOfCopies();
                if (book.getCode() == code) {
                    if (num != 0) {
                        book.setNumOfCopies(num - 1);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void getBookByGenreRating(String genre, int rate) {

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getGenre().equals(genre)) {
                if (book.CalcRating() >= rate) {
                    System.out.println(book);
                }

            }

        }


    }
}

class Invoice {
    private int day;
    private String num;
    private String name;
    private double fuel;

    public Invoice(int day, String num, String name, double fuel) {
        this.day = day;
        this.num = num;
        this.name = name;
        this.fuel = fuel;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "\nInvoice{" +
                "day=" + day +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", fuel=" + fuel +
                '}';
    }
}

class MonthFuel {
    static int TOTAL_MONTH = 32;
    static int TOTAL_INVOICE = 1000;
    static int INDEX_TOTAL = 0;

    private Invoice[] invoice;
    private int current;
    private double totalFuel;
    private double[] fuelPerDay;

    public MonthFuel() {
        current = 0;
        invoice = new Invoice[TOTAL_INVOICE];
        totalFuel = 0;
        fuelPerDay = new double[TOTAL_MONTH];
    }

    public boolean addInvoice(Invoice in) {
        if (invoice == null || current == this.invoice.length) {
            System.out.println("Invalid Argument");
            return false;
        }
        this.invoice[current] = in;
        totalFuel += in.getFuel();
        fuelPerDay[INDEX_TOTAL] = totalFuel;
        fuelPerDay[in.getDay()] += in.getFuel();
        current++;
        return true;
    }

    public boolean addInvoice(int day, String num, String name, double fuel) {
        if (invoice == null || current == this.invoice.length) {
            System.out.println("Invalid Argument");
            return false;
        }
        this.invoice[current] = new Invoice(day, num, name, fuel);
        current++;
        totalFuel += fuel;
        fuelPerDay[INDEX_TOTAL] = totalFuel;
        fuelPerDay[day] += fuel;
        return true;
    }

    public double[] FuelPerDay() {
        double[] fuelPerDay = new double[current];

        for (int i = 0; i < current; i++) {

            Invoice item = invoice[i];
            int day = item.getDay();
            double fuel = item.getFuel();

            fuelPerDay[day] += fuel;
            fuelPerDay[INDEX_TOTAL] += fuel;
        }
        return fuelPerDay;
    }

    public double[] FuelPerDay_() {
        return fuelPerDay;
    }

    public String MaxFuelPerCar() {
        double currentCarFuel;
        double nextCarFuel;
        String numberOfCar = invoice[0].getName();

        for (int i = 0; i < current; i++) {
            currentCarFuel = getFuelByNumCar(invoice[i]);
            for (int j = 0; j < current; j++) {
                nextCarFuel = getFuelByNumCar(invoice[j]);
                if (currentCarFuel < nextCarFuel) {
                    numberOfCar = invoice[j].getNum();
                }
            }
        }
        return numberOfCar;
    }

    public String MaxFuelPerCar2() {
        ArrayList<Double> fuelPerCar = new ArrayList<>();
        ArrayList<String> numberOfCar = new ArrayList<>();
        for (int i = 0; i < current; i++) {
            Invoice in = invoice[i];
            if (!numberOfCar.contains(in.getNum())) {
                numberOfCar.add(in.getNum());
                fuelPerCar.add(getFuelByNumCar(in));
            }
        }
        String number = "";
        double max = 0;
        for (int i = 0; i < fuelPerCar.size(); i++) {
            if (max < fuelPerCar.get(i)) {
                max = fuelPerCar.get(i);
                number = numberOfCar.get(i);
            }
        }
        return number;
    }

    private double getFuelByNumCar(Invoice in) {
        double fuel = 0;
        for (int j = 0; j < current; j++) {
            if (invoice[j].getNum().equals(in.getNum())) {
                fuel += in.getFuel();
            }
        }
        return fuel;
    }

    @Override
    public String toString() {
        return "MonthFuel{" +
                "\ninvoice=" + Arrays.toString(invoice) +
                ",\ncurrent=" + current +
                ",\ntotalFuel=" + totalFuel +
                ",\nfuelPerDay=" + Arrays.toString(fuelPerDay) +
                '}';
    }
}

class Country {
    private String name;
    private int infected;
    private int recovered;
    private int dead;

    public Country(String name, int infected, int recovered, int dead) {
        this.name = name;
        this.infected = infected;
        this.recovered = recovered;
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
}

class Status {


    private String names;
    private int count1;
    private int count2;

    public Status() {
        this.names = "";
        this.count1 = 0;
        this.count2 = 0;
    }

    public Status(String names, int count1, int count2) {
        this.names = names;
        this.count1 = count1;
        this.count2 = count2;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }
}

class SportClube {

    private String name;
    private String sportName;
    private String city;
    private int countOfPlayer;
    private int countOfCoach;

    public SportClube(String name, String sportName, String city, int countOfPlayer, int countOfCoach) {
        this.name = name;
        this.sportName = sportName;
        this.city = city;
        this.countOfPlayer = countOfPlayer;
        this.countOfCoach = countOfCoach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountOfPlayer() {
        return countOfPlayer;
    }

    public void setCountOfPlayer(int countOfPlayer) {
        this.countOfPlayer = countOfPlayer;
    }

    public int getCountOfCoach() {
        return countOfCoach;
    }

    public void setCountOfCoach(int countOfCoach) {
        this.countOfCoach = countOfCoach;
    }
}

class SportUnion {

    static int MAX_DATA = 100;

    private String UnionName;
    private SportClube[] unionData;
    private int numberUnion;


    public SportUnion(String unionName) {
        UnionName = unionName;
        this.unionData = new SportClube[MAX_DATA];
        this.numberUnion = 0;
    }

    public static int getMaxData() {
        return MAX_DATA;
    }

    public static void setMaxData(int maxData) {
        MAX_DATA = maxData;
    }

    public String getUnionName() {
        return UnionName;
    }

    public void setUnionName(String unionName) {
        UnionName = unionName;
    }

    public SportClube[] getUnionData() {
        return unionData;
    }

    public void setUnionData(SportClube[] unionData) {
        this.unionData = unionData;
    }

    public int getNumberUnion() {
        return numberUnion;
    }

    public void setNumberUnion(int numberUnion) {
        this.numberUnion = numberUnion;
    }

    public boolean addSportClub(SportClube sportClube) {

        if (sportClube == null)
            return false;

        for (int i = 0; i < numberUnion; i++) {
            SportClube current = unionData[i];

            String currentCity = current.getCity();
            String tempCity = sportClube.getCity();

            String currentSportName = current.getSportName();
            String tempSportName = sportClube.getSportName();

            if (currentCity.equals(tempCity) && currentSportName.equals(tempSportName))
                return false;
        }

        unionData[numberUnion++] = sportClube;
        return true;
    }

    public String maxCountOfCoach() {
        int max = 0;
        String nameSport = "";

        for (int i = 0; i < numberUnion; i++) {
            SportClube current = unionData[i];
            if (max < current.getCountOfCoach()) {
                max = current.getCountOfCoach();
                nameSport = current.getSportName();
            }
        }

        return nameSport;
    }
}