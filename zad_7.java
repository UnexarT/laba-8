public class zad_7 {
    public static void zad_7() {
        MyMass arr = new MyMass();
        System.out.println("Введите порядок квадратной матрици nxn:");
        int n = arr.GetN("n");
        int mas[][] = MasFor7(n);
        arr.PntIntMas_x2(mas);
    }
    public static int[][] MasFor7(int n){
        int mas[][] = new int[n][n];
        int x = n;
        int count = 0;
        int b = n/2;
        if (n%2 != 0){
            b = (n/2)+1;
        }
        while (x > b) {
            for (int i = 0; i < x; i++) {
                count++;
                mas[x - 1][i] = count;
            }
            for (int i = x - 2; i >= n-x; i--) {
                count++;
                mas[i][x-1] = count;
            }
            for (int i = x - 2; i >= 0 ; i--) {
                count++;
                mas[n - x][i] = count;
            }
            x--;
            if (n % 2 != 0 && x == (n / 2) + 1) {
                for (int i = 0; i < x; i++) {
                    count++;
                    mas[x-1][i] = count;
                }
            }
        }
        return mas;
    }
}
