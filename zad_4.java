import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.*;

public class zad_4 {
    public static void zad_4() {
        MyMass arr = new MyMass();
        int A[] = arr.RandIntMas(6,0,10);
        int b[] = Arrays.copyOf(A,A.length);
        arr.PntIntMas(A);
        System.out.println("Сортировка Шейкер: ");
        int left = 0, right = A.length - 1;
        int fl = 1;
        int count = 0;
        while ((left < right) && fl > 0) {
            fl = 0;
            for (int i = left; i< right; i++){
                if (A[i]>=A[i + 1]) {
                    int t = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = t;
                    fl = 1;
                    count++;
                    arr.PntIntMas(A);
                }
            }
            right--;
            for (int i = right; i>left; i--) {
                if (A[i - 1]>=A[i]) {
                    int t = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = t;
                    fl = 1;
                    count++;
                    arr.PntIntMas(A);
                }
            }
            left++;
        }
        System.out.println();
        arr.PntIntMas(A);
        System.out.println("Кол-во итераций: "+count);
        System.out.println();
        System.out.println("Сортипровка Пузырек: ");
        int count1 = 0;
        for (int i = 0; i < b.length; i++){
            for (int j = 0; j < b.length; j++){
                if (b[i] <= b[j]) {
                    int x = b[i];
                    b[i] = b[j];
                    b[j] = x;
                    count1++;
                    arr.PntIntMas(b);
                }
            }
        }
        System.out.println();
        arr.PntIntMas(b);
        System.out.println("Кол-во итераций: "+count1);
        System.out.println();
        System.out.printf("Сортировка Шейкер на %d и в %d раза быстрее",count1-count,count1/count);
    }
}
