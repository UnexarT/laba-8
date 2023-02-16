import java.util.Scanner;

public class zad_6 {
    public static void zad_6() {
        MyMass arr = new MyMass();
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите матрицу данных по ученикам в соответствующий столбец:\n" +
                "0)масса(кг)\n" +
                "1)рост(см)\n" +
                "2)успеваемость\n" +
                "3)численность семьи\n");
        System.out.println("Кол-вом строчек(N) определяется количество учеников!");
        double mas[][] = arr.GetMas();
        System.out.printf("\nЗадайте погрешность d: ");
        double d = Math.abs(scn.nextDouble());
        Vivod(Unic(2,mas),MasMid(2,d,mas));
    }
    public static double[] Unic(int k, double[][] mas){
        double[] mas1 = new double[1];
        double m = 0;
        for(int i = 0; i < mas.length; i++){
            if(mas[i][k] > m){
                m = mas[i][k];
                mas1 = mas[i];
            }
        }
        return mas1;
    }
    public static double[][] MasMid(int k,double d,double[][] mas){
        double masMid[][] = new double[CountMid(k,d,mas)][1];
        int cnt = -1;
        for (int i = 0; i < mas.length; i++) {
            if (Math.abs(mas[i][k] - Middle(k, mas)) <= d) {
                cnt++;
                masMid[cnt] = mas[i];
            }
        }
        return masMid;
    }
    public static int CountMid(int k,double d,double[][] mas){
        int cnt = 0;
        for (int i = 0; i < mas.length; i++) {
            if (Math.abs(mas[i][k] - Middle(k, mas)) <= d) {
                cnt++;
            }
        }
        return cnt;
    }
    public static double Middle(int k,double[][] mas){
        double cnt = 0;
        for (int i = 0; i < mas.length;i++){
            cnt+=mas[i][k];
        }
        return cnt/ mas.length;
    }
    public static void Krit(double a,double b,double c,int d){
        System.out.printf(
                "- масса = %.1f кг;\n" +
                        "- рост = %.1f см;\n" +
                        "- успеваемость = %.1f из 5 возожных;\n" +
                        "- численность семьи = %d человек.\n", a,b,c,d);
    }
    public static void Vivod(double[] mas1, double[][] mas2){
        System.out.println("\nИнформация о среднестатестических учениках.");
        for(int i = 0; i < mas2.length;i++){
            System.out.printf("%d ученик:\n", i+1);
            Krit(mas2[i][0],mas2[i][1],mas2[i][2],(int)mas2[i][3]);
        }
        System.out.println("\nИнформация о уникальном по успеваемости ученике.");
        Krit(mas1[0],mas1[1],mas1[2],(int)mas1[3]);
    }
}
