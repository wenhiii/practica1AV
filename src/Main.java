public class Main {
    public static void main(String[] args) {
        int[] c = {0, 7, 5, 2, 16, 11, 23, 15, 12, 24};
        int[] f = {3, 8, 11, 18, 20, 21, 24, 24, 25, 29};

        int[] c2 = {1, 3, 0, 5, 8, 5};
        int[] f2 = {2, 4, 6, 7, 9, 9};

        int[] c3 = {0, 3, 1, 5, 6, 9, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
        int[] f3 = {2, 4, 5, 7, 8, 10, 12, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37};


        boolean[] seleccion = AlgoritmoIdealizado.seleccionarActividades(c2, f2);
        boolean[] seleccion2 = AlgoritmoRealista.seleccionarActividades(c2, f2);

        System.out.println("Actividades seleccionadas:");
        int contador = 0;
        for (int i = 0; i < seleccion.length; i++) {
            if (seleccion[i]) {
                System.out.println("Actividad " + i + ": [" + c[i] + ", " + f[i] + ")");
                contador++;
            }
        }
        System.out.println("Total de actividades seleccionadas: " + contador);
    }
}
