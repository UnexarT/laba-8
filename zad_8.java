public class zad_8 {
    public static void zad_8() {
        MyMass arr = new MyMass();
        System.out.println("Введите порядок квадратной матрици nxn:");
        int n = arr.GetN("n");
        int mas[][] = BigMas(n);
        arr.PntIntMas_x2(mas);
    }
    public static int[][] BigMas(int n){
        int mas[][] = new int[n][n];
        if (n%2 != 0) {
            int MasLeft[][] = MasFor8(n / 2);
            int MasRight[][] = MasFor8(n / 2 + 1);
            for (int j = 0; j < MasLeft.length; j++) {
                for (int i = 0; i < MasLeft.length; i++) {
                    mas[j][i] = MasLeft[j][i];
                    mas[j + n / 2 + 1][i] = MasLeft[j][i];
                }
            }
            for (int j = 0; j < MasRight.length; j++) {
                for (int i = 0; i < MasRight.length; i++) {
                    mas[j][i + n / 2] = MasRight[j][i];
                    mas[j + n / 2][i + n / 2] = MasRight[j][i];
                }
            }
        } else {
            int Mas[][] = MasFor8(n / 2);
            for (int j = 0; j < Mas.length; j++) {
                for (int i = 0; i < Mas.length; i++) {
                    mas[j][i] = Mas[j][i];
                    mas[j + n / 2][i] = Mas[j][i];
                    mas[j][i+n/2] = Mas[j][i];
                    mas[j + n / 2][i+n/2] = Mas[j][i];
                }
            }
        }
        return mas;
    }
    public static int[][] MasFor8(int n){
        int mas[][] = new int[n][n];
        int count = 0;
        int j = 0;
        while (j < n-1){
            for (int i = n-1; i >= j; i--){
                count++;
                mas[j][i] = count;
            }
            for (int i = j+1; i < n; i++){
                count++;
                mas[i][j] = count;
            }
            j++;
            if (j == n-1){
                count++;
                mas[j][j] = count;
            }
        }
        return mas;
    }
}
