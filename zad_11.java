import java.util.Scanner;
import static java.lang.Math.*;

public class zad_11 {
    public static void zad_11() {
        MyMass arr = new MyMass();
        System.out.println("Задайте кол-во треугольнтков(N).");
        int N = arr.GetN("N");
        Print(Proverka(GetXY(N),N));
    }

    public static void Print(double[][] mas){
        System.out.println("Результаты проверки:");
        for(int i = 0; i < mas[0].length; i++) {
            System.out.printf("Треугольник №%d:\n", (i+1));
            if (mas[0][i] == 0) {
                System.out.println("- не существует");
            } else {
                System.out.println("- существует");
                if (mas[1][i] == 1) {
                    System.out.println("- равносторонний");
                } else if (mas[1][i] == 2) {
                    System.out.println("- прямоугольный");
                } else if (mas[1][i] == 3) {
                    System.out.println("- равнобедренный");
                } else {
                    System.out.println("- произвольный");
                }
                System.out.printf("S%d = %.5f\n",i+1, mas[2][i]);
                for(int j = 0; j < mas[0].length; j++){
                    if (i != j && mas[2][i] == mas[2][j] ){
                        System.out.printf("S%d = S%d \n", i+1, j+1);
                    }
                }
            }
            System.out.println();
        }
    }

    public static double Square(double a,double b, double c){
        double p = (a + b + c)/2;
        return pow(p*(p-a)*(p-b)*(p-c),1/2f);
    }

    public static double Dlin(double x1, double x2, double y1, double y2){
        return pow(pow(x2-x1,2) + pow(y2-y1,2),1/2f);
    }

    public static double[][] Proverka(double MasXY[][],int N){
        double[][] MasProver = new double[3][N];
        for(int i = 0; i < N; i++) {
            double fst = Dlin(MasXY[0][i * 3], MasXY[0][i * 3 + 1], MasXY[1][i * 3], MasXY[1][i * 3 + 1]);
            double sec = Dlin(MasXY[0][i * 3 + 1], MasXY[0][i * 3 + 2], MasXY[1][i * 3 + 1], MasXY[1][i * 3 + 2]);
            double thr = Dlin(MasXY[0][i * 3 + 2], MasXY[0][i * 3], MasXY[1][i * 3 + 2], MasXY[1][i * 3]);
            if ((fst >= sec + thr) || (sec >= fst + thr) || (thr >= fst + sec)) {
                for (int j = 0; j < 3; j++) {
                    MasProver[j][i] = 0;
                }
            } else {
                MasProver[0][i] = 1;
                if (fst == sec && fst == thr) {
                    MasProver[1][i] = 1;
                } else if (fst == pow(sec * sec + thr * thr, 1 / 2f) || sec == pow(fst * fst + thr * thr, 1 / 2f) ||
                        thr == pow(sec * sec + fst * fst, 1 / 2f)) {
                    MasProver[1][i] = 2;
                } else if (fst == sec || sec == thr || thr == fst) {
                    MasProver[1][i] = 3;
                } else {
                    MasProver[1][i] = 4;
                }
                MasProver[2][i] = Square(fst, sec, thr);
            }
        }
        return MasProver;
    }

    public static double[][] GetXY(int N){
        Scanner scn = new Scanner(System.in);
        double mas[][] = new double[2][3 * N];
        for(int i = 0; i < 3*N; i ++){
            System.out.printf("Введите координаты %d - го треугольника. \n", i/3+1);
            System.out.printf("%d - я вершина треугольника. \n", i%3+1);
            for (int j = 0; j < 2; j++){
                if(j == 0) {
                    System.out.printf("x = ");
                } else {
                    System.out.printf("y = ");
                }
                mas[j][i] = scn.nextDouble();
            }
            System.out.println();
        }
        return mas;
    }
}
