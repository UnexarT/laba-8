public class zad_9 {
    public static void zad_9() {
        MyMass arr = new MyMass();
        System.out.println("Введите порядок квадратной матрици 2nx2n:");
        int n = 2 * arr.GetN("n");
        int mas[][] = BigMas(n);
        arr.PntIntMas_x2(mas);
    }
    public static int[][] BigMas(int n){
        int mas[][] = new int[n][n];
        int MasLeft[][] = MasFor9(n / 2 ,"left");
        int MasRight[][] = MasFor9(n / 2,"right");
        for (int j = 0; j < MasLeft.length; j++) {
            for (int i = 0; i < MasLeft.length; i++) {
                mas[j][i] = MasLeft[j][i];
                mas[j + n / 2][i] = MasLeft[j][i];
            }
        }
        for (int j = 0; j < MasRight.length; j++) {
            for (int i = 0; i < MasRight.length; i++) {
                mas[j][i + n / 2] = MasRight[j][i];
                mas[j + n / 2][i + n / 2] = MasRight[j][i];
            }
        }
        return mas;
    }
    public static int[][] MasFor9(int n, String m){
        int mas[][] = new int[n][n];
        int count = 0;
        if (m.equals("left")) {
            while (mas[0][0] == 0) {
                for (int i = 1; i <= n; i++) {
                    int y = i;
                    for (int x = 1; x <= i; x++) {
                        count++;
                        if (i % 2 == 1) {
                            mas[n - x][n - y] = count;
                        } else {
                            mas[n - y][n - x] = count;
                        }
                        y--;
                    }
                }
                for (int i = 2; i <= n; i++) {
                    int y = i;
                    for (int x = n; x >= i; x--) {
                        count++;
                        if (i % 2 == 1) {
                            mas[n - y][n - x] = count;
                        } else {
                            mas[n - x][n - y] = count;
                        }
                        y++;
                    }
                }
            }
        } else if (m.equals("right")) {
            for (int i = 0; i <= n-2; i++) {
                int y = i+1;
                for (int x = 0; x < n - i; x++) {
                    if (mas[x][i] == 0) {
                        count++;
                        mas[x][i] = count;
                    }
                }
                for (int x = i*2; x < n-1; x++) {
                    count++;
                    mas[n-x-2][y] = count;
                    y++;
                }
            }
        }
        return mas;
    }
}

