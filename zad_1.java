import java.util.Scanner;

public class zad_1 {
    public static void zad_1() {
        MyMass arr = new MyMass();
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите размерность массива N:");
        int N = arr.GetN("N");
        int mas[] = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.printf("Введите в %d элемент массива число в диапазоне [0;8]: ", i);
            int x = scn.nextInt();
            if (x < 0 || x > 8 || (i == 0 && x == 0)) {
                System.out.println("Введено недопустимое число!");
                i--;
            } else {
                mas[i] = x;
            }
        }
        System.out.println("В 9-ой: ");
        arr.PntIntMas(mas);
        System.out.println();
        System.out.println("В 10-ой: ");
        arr.PntIntMas(GetMas10(mas));
    }
    public static int[] GetMas10(int mas[]) {
        double num = 0;
        for (int i = 0; i < mas.length; i++){
            num += mas[i]*Math.pow(9,-(i+1));
        }
        int mas10[] = new int[6];
        for (int i = 0; i < 6; i++){
            num = num*10;
            mas10[i] = (int) num;
            num = num - (int) num;
        }
        return mas10;
    }
}