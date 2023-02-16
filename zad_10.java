public class zad_10 {
    public static void zad_10() {
        MyMass arr = new MyMass();
        System.out.println("Введите количество точек N:");
        int N = arr.GetN("N");
        int mas[][] = arr.RandIntMas_x2(2, N, -7, 6);
        for (int i = 0; i < N; i++){
            if (arr.Figure_Laba5(mas[0][i],mas[1][i]) == 1) {
                System.out.printf("Точка (%d, %d) попала внутрь данной фигуры \n", mas[0][i],mas[1][i]);
            } else if (arr.Figure_Laba5(mas[0][i],mas[1][i]) == 0) {
                System.out.printf("Точка (%d, %d) попала на границу данной фигуры \n", mas[0][i],mas[1][i]);
            } else {
                System.out.printf("Точка (%d, %d) не попала ни внутрь ни на границу данной фигуры \n", mas[0][i],mas[1][i]);
            }
        }
    }
}
