public class zad_5 {
    public static void zad_5(){
        MyMass arr = new MyMass();
        System.out.println("Введите порядок квадратной матрици NxN:");
        int N = arr.GetN("N");
        int a[][] = arr.RandIntMas_x2(N,N,0,10);
        arr.PntIntMas_x2(a);
        SumDiag(a,N);
    }
    public static void SumDiag(int mas[][],int N){
        int count = 0;
        for (int j = N-1; j >= 0; j--) {
            int sum = 0;
            int k = 0, n = j;
            while (n <= N - 1) {
                sum += mas[k][n];
                k++;
                n++;
            }
            count++;
            System.out.printf("Сумма %d-ой диагонали равна %d \n",count,sum);
        }
        for (int i = 1; i <= N-1; i++) {
            int sum = 0;
            int k = 0, n = i;
            while (n <= N - 1) {
                sum += mas[n][k];
                k++;
                n++;
            }
            count++;
            System.out.printf("Сумма %d-ой диагонали равна %d \n",count,sum);
        }
    }
}
