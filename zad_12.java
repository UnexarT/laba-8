public class zad_12 {
    public static void zad_12() {
        MyMass arr = new MyMass();
        double mas1[][] = arr.GetMas();
        double mas2[][] = arr.GetMas();
        if (Proverka(MasUmnoj(mas1,mas2))) {
            System.out.println("\nРезультаты проверки:\nОбратная матрица задана правильно!");
        } else {
            System.out.println("\nРезультаты проверки:\nОбратная матрица задана не правильно!");
        }
    }
    public static double[][] MasUmnoj(double[][] mas1, double[][] mas2){
        double mas[][] = new double[mas1.length][mas1.length];
        for(int i = 0; i < mas1.length; i++){
            for(int j = 0; j < mas1.length; j++) {
                for(int k = 0; k < mas1.length; k++){
                    mas[j][i] += mas1[j][k] * mas2[k][i];
                }
            }
        }
        return mas;
    }
    public static boolean Proverka(double[][] mas){
        for(int i = 0; i < mas.length; i++){
            for(int j = 0; j < mas.length;j++){
                if((i == j && mas[i][j] != 1) || (i != j && mas[i][j] != 0)){
                    return false;
                }
            }
        }
        return true;
    }
}
