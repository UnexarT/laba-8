import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.*;

public class MyMass {
    public void PntDblMas(double mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf(mas[i]+"\t");
        }
        System.out.println();
    }
    public void PntIntMas(int mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf(mas[i]+"\t");
        }
        System.out.println();
    }
    public void PntIntMas_x2(int mas[][]){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void PntDblMas_x2(double mas[][]){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf(mas[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[] RandIntMas(int b, int min, int max) {
        Random rnd = new Random();
        int A[] = new int[b];
        for (int i = 0; i < A.length; i++) {
            A[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return A;
    }
    public int[][] RandIntMas_x2(int a,int b, int min, int max) {
        MyMass arr = new MyMass();
        Random rnd = new Random();
        int A[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            A[i] = arr.RandIntMas(b, min, max);
        }
        return A;
    }
    public static void IntSheker(int a[]) {
        MyMass arr = new MyMass();
        int left = 0, right = a.length - 1;
        int flag = 1;
        int count = 0;
        while ((left < right) && flag > 0) {
            flag = 0;
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    flag = 1;
                    count++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    int t = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = t;
                    flag = 1;
                    count++;
                }
            }
            left++;
        }
        arr.PntIntMas(a);
    }
    public void IntBubble(int mass[]){
        MyMass arr = new MyMass();
        int count = 0;
        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < mass.length; j++){
                if (mass[i] >= mass[j]) {
                    int x = mass[i];
                    mass[i] = mass[j];
                    mass[j] = x;
                    count++;
                }
            }
        }
        arr.PntIntMas(mass);
    }
    public static int GetN(String a){
        Scanner scn = new Scanner(System.in);
        int N = 0;
        while(N == 0) {
            System.out.printf("%s = ", a);
            N = scn.nextInt();
            if (N <= 0) {
                System.out.println("Ошибка в веденных данных!");
                N = 0;
            }
        }
        System.out.println();
        return N;
    }
    public double[][] GetMas() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите количество строчек массива N:");
        int N = GetN("N");
        System.out.println("Введите количество столбцов массива M:");
        int M = GetN("M");
        double mas[][] = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("Задайте %d элемент %d строки: ", j, i);
                mas[i][j] = scn.nextDouble();
            }
        }
        return mas;
    }
    public int Figure_Laba5(double x, double y){
        if (figOne(x, y) == 0 || figTwo(x, y) == 0 || figThree(x, y) == 0 ||
                figFour(x, y) == 0 || figFive(x, y) == 0) {
            return 0;
        } else if (figOne(x, y) == 1 || figTwo(x, y) == 1 || figThree(x, y) == 1 ||
                figFour(x, y) == 1 || figFive(x, y) == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    public static double k(double x1,double y1,double x2,double y2){
        return (y1 - y2)/(x1 - x2);
    }
    public static double b(double x1,double y1,double x2,double y2){
        return y1 - x1*k(x1,y1,x2,y2);
    }

    public static int figOne(double x, double y) {
        if (y >= x * k(-4, 0, 1, 4) + b(-4, 0, 1, 4) &&
                y <= x * k(1, 4, -7, 5) + b(1, 4, -7, 5) &&
                y >= x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5)) {
            if (y == x * k(-4, 0, 1, 4) + b(-4, 0, 1, 4) ||
                    y == x * k(1, 4, -7, 5) + b(1, 4, -7, 5)) {
                return 0;
            }
            return 1;
        }
        return -1;
    }
    public static int figTwo(double x, double y) {
        if (y <= x * k(-4, 0, -7, 5) + b(-4, 0, -7, 5) &&
                y >= x * k(-6, -4, -7, 5) + b(-6, -4, -7, 5)  &&
                y >= x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0)) {
            if (y == x * k(-6, -4, -7, 5) + b(-6, -4, -7, 5)) {
                return 0;
            }
            return 1;
        }
        return -1;
    }
    public static int figThree(double x, double y) {
        if (y <= x * k(-6, -4, -4, 0) + b(-6, -4, -4, 0) &&
                y >= x * k(-2, -6, -6, -4) + b(-2, -6, -6, -4) &&
                y <= x * k(-2, -6, -4, 0) + b(-2, -6, -4, 0)) {
            if (y == x * k(-2, -6, -6, -4) + b(-2, -6, -6, -4) ||
                    y == x * k(-2, -6, -4, 0) + b(-2, -6, -4, 0)) {
                return 0;
            }
            return 1;
        }
        return -1;
    }
    public static int figFour(double x, double y) {
        if (y >= x * k(1, -7, 3, -4) + b(1, -7, 3, -4) &&
                y <= x * k(1, -2, 3, -1) + b(1, -2, 3, -1) &&
                x >= 1 && x <= 3) {
            if (y == x * k(1, -7, 3, -4) + b(1, -7, 3, -4) ||
                    y == x * k(1, -2, 3, -1) + b(1, -2, 3, -1) ||
                    x == 1) {
                return 0;
            }
            return 1;
        }
        return -1;
    }
    public static int figFive(double x, double y) {
        if (y <= x * k(3, -1, 5,2) + b(3, -1, 5,2) &&
                y >= x * k(3, -4, 6, -3) + b(3, -4, 6, -3) &&
                y <= x * k(6, -3, 5,2) + b(6, -3, 5,2) && x >= 3) {
            if (y == x * k(3, -1, 5,2) + b(3, -1, 5,2) ||
                    y == x * k(3, -4, 6, -3) + b(3, -4, 6, -3) ||
                    y == x * k(6, -3, 5,2) + b(6, -3, 5,2)) {
                return 0;
            }
            return 1;
        }
        return -1;
    }
}

