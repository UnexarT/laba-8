import java.util.Scanner;

public class zad_3 {
    public static void zad_3() {
        MyMass arr = new MyMass();
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите количество точек в плоскости N:");
        int N = arr.GetN("N");
        System.out.println("Введите константу k:");
        double k = scn.nextDouble();
        System.out.println("Введите константу b:");
        double b = scn.nextDouble();
        double mas[] = new double[2*N];
        for (int i = 0; i<2*N; i++){
            if ((i+1)%2 == 1){
                System.out.printf("Введите x%d: \n",i/2+1);
                mas[i] = scn.nextDouble();
            } else {
                System.out.printf("Введите y%d: \n",i/2+1);
                mas[i] = scn.nextDouble();
            }
        }
        for (int i = 0; i < 2*N; i+=2){
            if (mas[i+1] > k*mas[i]+b){
                System.out.printf("Точка %d выше данной прямой \n",i/2+1);
            }
        }
    }
}
