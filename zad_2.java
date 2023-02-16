import static java.lang.Math.abs;

public class zad_2 {
    public static void zad_2() {
        MyMass arr = new MyMass();
        double mas[][] = arr.GetMas();
        int i, j;
        i = j = 0;
        for (int x = 1; x < mas.length-2; x++) {
            if (mas[x] == mas[x+1]) {
                i = x;
                for (int y = i+1; y <= mas.length-2; y++) {
                    if (abs(mas[0][y]) == abs(mas[0][y+1])) {
                        j = y;
                    }
                }
            }
        }
        if (i != 0 && j != 0){
            System.out.println("Такие i и j существуют");
        } else {
            System.out.println("Такие i и j не существуют");
        }
    }
}
